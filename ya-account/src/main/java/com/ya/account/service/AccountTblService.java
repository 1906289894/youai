package com.ya.account.service;

import com.ya.account.entity.AccountTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wb 
 * @since 2022-05-16
 */
public interface AccountTblService extends IService<AccountTbl> {
    /**
     * 用户账户扣款
     * @param userId
     * @param money 从用户账户中扣除的金额
     */
    void debit(String userId, int money) ;
}
