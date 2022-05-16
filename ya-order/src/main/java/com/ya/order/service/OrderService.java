package com.ya.order.service;

import com.ya.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ya.order.vo.OrderVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wb
 * @since 2022-05-15
 */
public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     * @param orderVo 订单参数
     * @return 订单信息
     */
    Order saveOrder(OrderVo orderVo);
}
