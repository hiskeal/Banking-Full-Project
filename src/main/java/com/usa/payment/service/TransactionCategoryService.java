package com.usa.payment.service;


import com.usa.payment.Dto.*;
import com.usa.payment.model.TransactionCategory;
import com.usa.payment.repository.TransactionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionCategoryService {

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;


    public ResponseDto saveTransactionCategory(TransactionCategoryRequestDto transactionCategoryRequestDto) {

        TransactionCategory transactionCategory = new TransactionCategory();

        transactionCategory.setType(transactionCategoryRequestDto.getType());


        transactionCategoryRepository.save(transactionCategory);
        return new ResponseDto(true, "Transaction Category is Saved ");
    }

    public ResponseDto updateTransactionCategory(TransactionCategoryRequestDto transactionCategoryResponseDto, Long id) {

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(id).get();

        transactionCategory.setType(transactionCategoryResponseDto.getType());


        transactionCategoryRepository.save(transactionCategory);
        return new ResponseDto(true, "Transaction Category updated successes");
    }

    public ResponseDto deleteTransactionCategoryById(Long id) {
        transactionCategoryRepository.deleteById(id);
        return new ResponseDto(true, "deleted");
    }

    public List<TransactionCategory> ListAllTransactionCategory() {
        List<TransactionCategoryRequestDto> transactionCategoryRequestDtoList = new ArrayList<>();
        return (List<TransactionCategory>) transactionCategoryRepository.findAll();
    }

    public TransactionCategory getTransactionCategoryById(Long id){
        return transactionCategoryRepository.findById(id).get();
    }

}
