package com.ya.storage.mapper;

import com.ya.storage.entity.StorageTbl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wb
 * @since 2022-05-16
 */
@Mapper
public interface StorageTblMapper extends BaseMapper<StorageTbl> {
    /**
     * 获取库存
     * @param commodityCode 商品编号
     * @return
     */
    @Select("SELECT id,commodity_code,count FROM storage_tbl WHERE commodity_code = #{commodityCode}")
    StorageTbl findByCommodityCode(@Param("commodityCode") String commodityCode);

    /**
     * 扣减库存
     * @param commodityCode 商品编号
     * @param count  要扣减的库存
     * @return
     */
    @Update("UPDATE storage_tbl SET count = count - #{count} WHERE commodity_code = #{commodityCode}")
    int reduceStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
