package com.usa.payment.controller;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransactionRequestDto;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.Transfer;
import com.usa.payment.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/saveTransaction")
    public ResponseDto saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {
        return  transactionService.saveTransaction(transactionRequestDto);

    }

    @PutMapping("/updateTransaction/{id}")
    public ResponseDto updateTransaction(@RequestBody TransactionRequestDto transactionRequestDto, @PathVariable Long id) {
       return  transactionService.updateTransaction(transactionRequestDto, id);

    }

    @DeleteMapping("/deleteTransaction/{id}")
    public ResponseDto deleteTransaction(@PathVariable("id") Long id) {
        return  transactionService.deleteTransactionById(id);

    }

    @GetMapping("/listTransaction")
    public List<Transaction> ListAll() {
        return transactionService.ListAllTransaction();
    }

    @GetMapping("/getTransaction/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
         return (Transaction) transactionService.getTransactionById(id);
    }


}
