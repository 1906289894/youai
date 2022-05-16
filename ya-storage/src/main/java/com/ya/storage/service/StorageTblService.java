package com.ya.storage.service;

import com.ya.storage.entity.StorageTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wb
 * @since 2022-05-16
 */
public interface StorageTblService extends IService<StorageTbl> {
    /**
     * 扣减库存
     * @param commodityCode 商品编号
     * @param count 扣除数量
     */
    void deduct(String commodityCode, int count) ;
}
