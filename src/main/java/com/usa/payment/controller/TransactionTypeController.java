package com.usa.payment.controller;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransactionTypeRequestDto;
import com.usa.payment.model.TransactionType;
import com.usa.payment.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @PostMapping("/saveTransactionType")
    public ResponseDto saveTransactionType(@RequestBody TransactionTypeRequestDto transactionTypeRequestDto) {
        return transactionTypeService.saveTransactionType(transactionTypeRequestDto);
    }


    @PutMapping("/updateTransactionType/{id}")
    public ResponseDto updateTransactionType(@RequestBody TransactionTypeRequestDto transactionTypeRequestDto, @PathVariable Long id) {
        return  transactionTypeService.updateTransactionType(transactionTypeRequestDto, id);

    }

    @DeleteMapping("/deleteTransactionType/{id}")
    public ResponseDto deleteTransactionType(@PathVariable("id") Long id) {
        return  transactionTypeService.deleteTransactionTypeById(id);

    }

    @GetMapping("/listTransactionType")
    public List<TransactionType> ListAll() {
        return transactionTypeService.ListAllTransactionType();
    }

    @GetMapping("/getTransactionType/{id}")
    public TransactionType getTransactionTypeById(@PathVariable Long id) {
        return (TransactionType) transactionTypeService.getTransactionTypeById(id);
    }
}
