package com.ya.user.mapper;

import com.ya.user.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wb
 * @since 2022-05-09
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

}
