package com.ya.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wb
 * @description 账户feign
 * @date 2022-05-16 11:23
 */
@FeignClient(contextId = "feignAccountService", value = "ya-account")
public interface FeignAccountService {
    @PostMapping("/account/debit")
    void debit(@RequestParam("userId") String userId, @RequestParam("money") int money);
}
