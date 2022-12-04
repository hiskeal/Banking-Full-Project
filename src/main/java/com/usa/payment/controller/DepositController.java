package com.usa.payment.controller;

import com.usa.payment.Dto.DepositRequestDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.Deposit;
import com.usa.payment.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/saveDeposit")
    public ResponseDto saveDeposit(@RequestBody DepositRequestDto depositRequestDto) {
       return depositService.saveDeposit(depositRequestDto);

    }

    @PutMapping("/updateDeposit/{id}")
    public ResponseDto updateDeposit(@RequestBody DepositRequestDto depositRequestDto, @PathVariable Long id) {
       return depositService.updateDeposit(depositRequestDto, id);
    }

    @DeleteMapping("/deleteDeposit/{id}")
    public ResponseDto deleteDeposit(@PathVariable("id") Long id) {
       return depositService.deleteDeposit(id);
    }

    @GetMapping("/getAllDeposit")
    public List<Deposit> ListAllDeposit()
    {
       return depositService.ListAllDeposit();
    }

    @GetMapping("/getAllDeposit/{id}")
    public Deposit getDepositById(@PathVariable Long id) {
       return depositService.getDepositById(id);
    }

}
