package com.ya.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wb
 * @description 库存feign
 * @date 2022-05-16 11:16
 */
@FeignClient(contextId = "feignStorageService", value = "ya-storage")
public interface FeignStorageService {
    @PostMapping("/storage/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);
}
