package com.ya.order.controller;

import com.leyou.common.api.CommonResult;
import com.ya.order.entity.Order;
import com.ya.order.service.OrderService;
import com.ya.order.vo.OrderVo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wb
 * @since 2022-05-15
 */
@RestController
@RequestMapping("/order")
@AllArgsConstructor
@Log4j2
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/find")
    public List<Order> get(){
        return orderService.list();
    }

    @PostMapping("/createOrder")
    public CommonResult<Order> createOrder(@RequestBody OrderVo orderVo) throws Exception{
        log.info("收到下单请求,用户:{}, 商品编号:{}", orderVo.getUserId(), orderVo.getCommodityCode());
        Order order = orderService.saveOrder(orderVo);
        return CommonResult.success(order);
    }
}
