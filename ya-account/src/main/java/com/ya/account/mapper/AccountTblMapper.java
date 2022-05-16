package com.ya.account.mapper;

import com.ya.account.entity.AccountTbl;
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
public interface AccountTblMapper extends BaseMapper<AccountTbl> {
    /**
     * 查询账户
     * @param userId
     * @return
     */
    @Select("select id, user_id, money from account_tbl WHERE user_id = #{userId}")
    AccountTbl selectByUserId(@Param("userId") String userId);

    /**
     * 扣减余额
     * @param userId 用户id
     * @param money 要扣减的金额
     * @return
     */
    @Update("update account_tbl set money =money-#{money} where user_id = #{userId}")
    int reduceBalance(@Param("userId") String userId, @Param("money") Integer money);
}
