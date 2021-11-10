package handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// UrlBlockHandler的实现类
@Slf4j
public class MyUrlBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        log.info("UrlBlockHandler BlockException================"+e.getRule());

        CommonResult r = null;

        if (e instanceof FlowException) {
            r = CommonResult.failed(100,"接口限流了");

        } else if (e instanceof DegradeException) {
            r = CommonResult.failed(101,"服务降级了");

        } else if (e instanceof ParamFlowException) {
            r = CommonResult.failed(102,"热点参数限流了");

        } else if (e instanceof SystemBlockException) {
            r = CommonResult.failed(103,"触发系统保护规则了");

        } else if (e instanceof AuthorityException) {
            r = CommonResult.failed(104,"授权规则不通过");
        }

        //返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), r);
    }
}