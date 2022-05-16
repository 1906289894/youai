package com.ya.account.service.impl;

import com.ya.account.entity.AccountTbl;
import com.ya.account.mapper.AccountTblMapper;
import com.ya.account.service.AccountTblService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.AllArgsConstructor;
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
public class AccountTblServiceImpl extends ServiceImpl<AccountTblMapper, AccountTbl> implements AccountTblService {
    @Transactional
    @Override
    public void debit(String userId, int money) {
        log.info("==========用户账户扣款=========");
        log.info("当前 XID: {}", RootContext.getXID());

        //检查用户余额
        checkBalance(userId,money);

        log.info("开始扣减用户 {} 余额", userId);
        int record = baseMapper.reduceBalance(userId, money);
        log.info("扣减用户 {} 余额结果：{}", userId, record>0?"操作成功":"扣减失败");
    }

    private void checkBalance(String userId,int money){
        log.info("检查用户 {} 余额", userId);
        AccountTbl account = baseMapper.selectByUserId(userId);
        if (Objects.isNull(account)){
            throw new RuntimeException("账户不存在");
        }
        if (account.getMoney()<money){
            log.warn("用户 {} 余额不足，当前余额：{}",userId, account.getMoney());
            throw new RuntimeException("余额不足");
        }
    }
}
