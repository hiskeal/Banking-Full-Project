package com.usa.payment.controller;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.WithdrawRequestDto;
import com.usa.payment.model.Transfer;
import com.usa.payment.model.Withdraw;
import com.usa.payment.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    @PostMapping ("/saveWithdraw")
    public ResponseDto saveWithdraw (@RequestBody WithdrawRequestDto withdrawRequestDto) {

        return withdrawService.saveWithdraw(withdrawRequestDto);
    }

    @PutMapping("/updateWithdraw/{id}")
    public ResponseDto updateWithdraw(@RequestBody WithdrawRequestDto withdrawRequestDto, @PathVariable Long id) {
        return withdrawService.updateWithdraw(withdrawRequestDto, id);
    }

    @DeleteMapping("/deleteWithdraw/{id}")
    public ResponseDto deleteWithdraw(@PathVariable ("id") long id){

        return withdrawService.deleteWithdrawById(id);
    }

    @GetMapping("/getWithdraw")
    public List<Withdraw> getAllWithdraw() {

        return withdrawService.ListAll();
    }

    @GetMapping("/getWithdraw/{id}")
    public Withdraw getWithdrawById(@PathVariable Long id) {
        return withdrawService.getWithdrawById(id);
    }
}
