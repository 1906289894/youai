package com.ya.order.mapper;

import com.ya.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wb
 * @since 2022-05-15
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
