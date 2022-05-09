package com.ya.user.service.impl;

import com.ya.user.entity.TbUser;
import com.ya.user.mapper.TbUserMapper;
import com.ya.user.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wb
 * @since 2022-05-09
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

}
