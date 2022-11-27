package com.usa.payment.controller;

import com.usa.payment.Dto.AccountRequestDto;
import com.usa.payment.Dto.ResponseDto;

import com.usa.payment.model.Account;
import com.usa.payment.service.AccountService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/saveAccount")
    public ResponseDto saveAccount(@RequestBody AccountRequestDto accountRequestDto) {
       return accountService.saveAccount(accountRequestDto);

    }

    @PutMapping("/updateAccount/{id}")
    public ResponseDto updateAccount(@RequestBody AccountRequestDto accountRequestDto, @PathVariable Long id) {
       return  accountService.updateAccount(accountRequestDto, id);

    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseDto deleteAccount(@PathVariable("id") Long id) {
        return  accountService.deleteAccountById(id);

    }

    @GetMapping("/listAccount")
    public List<Account> ListAll() {
        return accountService.ListAll();
    }

    @GetMapping("/getAccount/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/active/{id}")
    public ResponseDto active(@PathVariable Long id) {
        return accountService.active(id);
    }
}
