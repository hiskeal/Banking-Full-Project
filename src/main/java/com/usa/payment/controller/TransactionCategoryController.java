package com.usa.payment.controller;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransactionCategoryRequestDto;
import com.usa.payment.model.TransactionCategory;
import com.usa.payment.model.TransactionType;
import com.usa.payment.service.TransactionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
public class TransactionCategoryController {

    @Autowired
    private TransactionCategoryService transactionCategoryService;

    @PostMapping("/saveTransactionCategory")
    public ResponseDto saveTransactionCategory(@RequestBody TransactionCategoryRequestDto transactionCategoryRequestDto) {
        return transactionCategoryService.saveTransactionCategory(transactionCategoryRequestDto);
    }


    @PutMapping("/updateTransactionCategory/{id}")
    public ResponseDto updateTransactionCategory(@RequestBody TransactionCategoryRequestDto transactionCategoryRequestDto, @PathVariable Long id) {
        return  transactionCategoryService.updateTransactionCategory(transactionCategoryRequestDto, id);

    }

    @DeleteMapping("/deleteTransactionCategory/{id}")
    public ResponseDto deleteTransactionCategory(@PathVariable("id") Long id) {
        return  transactionCategoryService.deleteTransactionCategoryById(id);

    }

    @GetMapping("/listTransactionCategory")
    public List<TransactionCategory> ListAll() {
        return transactionCategoryService.ListAllTransactionCategory();
    }

    @GetMapping("/getTransactionCategory/{id}")
    public TransactionCategory getTransactionCategoryById(@PathVariable Long id) {
        return (TransactionCategory) transactionCategoryService.getTransactionCategoryById(id);
    }
}
