package com.ya.storage.service.impl;

import com.ya.storage.entity.StorageTbl;
import com.ya.storage.mapper.StorageTblMapper;
import com.ya.storage.service.StorageTblService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wb
 * @since 2022-05-16
 */
@Service
@Log4j2
public class StorageTblServiceImpl extends ServiceImpl<StorageTblMapper, StorageTbl> implements StorageTblService {
    @Transactional
    @Override
    public void deduct(String commodityCode, int count) {
        log.info("==========扣減庫存==========");
        log.info("当前 XID: {}", RootContext.getXID());
        //检查库存
        checkStock(commodityCode,count);
        log.info("开始扣减 {} 库存", commodityCode);
        int record = baseMapper.reduceStorage(commodityCode, count);
        log.info("扣减{}库存结果：{}",commodityCode,record>0?"操作成功":"扣减失败");
    }
    private void checkStock(String commodityCode, int count){
        log.info("检查 {} 库存", commodityCode);
        StorageTbl storage = baseMapper.findByCommodityCode(commodityCode);
        if (Objects.isNull(storage)){
            throw new RuntimeException("库存不存在");
        }
        if (storage.getCount() < count){
            log.warn("{} 库存不足, 当前库存：{}", commodityCode, count);
            throw new RuntimeException("库存不足");
        }
    }

}
