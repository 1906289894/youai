package com.ya.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.leyou.common.enums.OrderStatus;
import com.ya.order.entity.Order;
import com.ya.order.feign.FeignAccountService;
import com.ya.order.feign.FeignStorageService;
import com.ya.order.mapper.OrderMapper;
import com.ya.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ya.order.vo.OrderVo;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wb
 * @since 2022-05-15
 */
@Service
@Log4j2
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    private final FeignStorageService feignStorageService;
    private final FeignAccountService feignAccountService;
    @Override
    //@Transactional
    @GlobalTransactional(name="createOrder")
    public Order saveOrder(OrderVo orderVo) {
        log.info("==========用户下单==========");
        log.info("当前 XID: {}", RootContext.getXID());

        //保存订单
        Order order = new Order();
        order.setUserId(orderVo.getUserId());
        order.setCommodityCode(orderVo.getCommodityCode());
        order.setCount(orderVo.getCount());
        order.setMoney(orderVo.getMoney());
        order.setStatus(OrderStatus.INIT.getValue());
        boolean save = this.save(order);
        log.info("保存订单{}", save?"成功":"失败");
        /*扣减库存*/
        feignStorageService.deduct(orderVo.getCommodityCode(),orderVo.getCount());

        //扣减余额
        feignAccountService.debit(orderVo.getUserId(),orderVo.getMoney());

        log.info("==========更新订单状态==========");
        //更新订单
        boolean update = this.update(new UpdateWrapper<Order>()
                .set("status", OrderStatus.SUCCESS.getValue()).eq("id", order.getId()));
        log.info("更新订单id:{}-{}",order.getId(),update?"成功":"失败");
        return order;
    }
}
