package com.leyou.item.web;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.api.CommonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 统一资源入口异常拦截
 * @Author wb
 * @Date 2021/11/10 17:11
 */
@Component
@Log4j2
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
       log.info("BlockExceptionHandler error===================="+e.getRule());
        CommonResult<Void> result = null;
       if (e instanceof FlowException){
           result = CommonResult.failed(100,"接口被限流了");
       }

       else if (e instanceof DegradeException){
           result = CommonResult.failed(101,"服务降级了");
       }

       else if (e instanceof ParamFlowException){
           result = CommonResult.failed(102,"热点参数限流了");
       }

       else if (e instanceof SystemBlockException){
           result = CommonResult.failed(103,"触发系统保护规则了");
       }

       else if (e instanceof AuthorityException){
           result = CommonResult.failed(104,"授权规则不通过");
       }

       httpServletResponse.setStatus(500);
       httpServletResponse.setCharacterEncoding("utf-8");
       httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
       new ObjectMapper().writeValue(httpServletResponse.getWriter(),result);
    }
}
