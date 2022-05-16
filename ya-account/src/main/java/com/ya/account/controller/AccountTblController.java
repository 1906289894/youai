package com.ya.account.controller;

import com.ya.account.service.AccountTblService;
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
@RequestMapping("/account")
@AllArgsConstructor
public class AccountTblController {
    private final AccountTblService accountTblService;
    @PostMapping("/debit")
    public void debit(@RequestParam String userId, @RequestParam int money){
        accountTblService.debit(userId,money);
    }
}
