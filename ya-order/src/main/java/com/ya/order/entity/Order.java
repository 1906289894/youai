package com.ya.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wb
 * @since 2022-05-15
 */
@Getter
@Setter
@TableName("order_tbl")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private String userId;

    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Integer count;

    @TableField("money")
    private Integer money;

    @TableField("status")
    private Integer status;


}
