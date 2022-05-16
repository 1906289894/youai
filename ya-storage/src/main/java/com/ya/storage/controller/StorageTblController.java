package com.ya.storage.controller;

import com.ya.storage.service.StorageTblService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wb
 * @since 2022-05-16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageTblController {
    private StorageTblService service;
    @PostMapping("/deduct")
    public void deduct(@RequestParam String commodityCode, @RequestParam int count){
        service.deduct(commodityCode,count);
    }
}
