package com.ya.user.controller;

import com.alibaba.cloud.sentinel.custom.SentinelAutoConfiguration;
import com.ya.user.entity.TbUser;
import com.ya.user.service.TbUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wb
 * @since 2022-05-09
 */
@RestController
@RequestMapping("/tbUser")
@AllArgsConstructor
public class TbUserController {
    private TbUserService tbUserService;
    //SentinelAutoConfiguration
    @GetMapping
    public List<TbUser> get(){
       return tbUserService.list();
    }

    @RequestMapping("/1")
    public String message1(){
        return "远程电泳";
    }

    @RequestMapping("/2")
    public String message2(){
        return "this is message2";
    }

}
