package com.usa.payment.service;


import com.usa.payment.Dto.*;
import com.usa.payment.model.Account;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.TransactionCategory;
import com.usa.payment.model.TransactionType;

import com.usa.payment.repository.AccountRepository;
import com.usa.payment.repository.TransactionCategoryRepository;
import com.usa.payment.repository.TransactionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.usa.payment.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction withdrawTransaction(WithdrawRequestDto withdrawRequestDto) {

        Transaction transaction = new Transaction();

        transaction.setCreatedOn(new Date());
        // Transaction Type & Withdraw are saved on both way
        TransactionType transactionType = transactionTypeRepository.findById(5L).get();
        transaction.setTransactionType(transactionType);

        String uuid = UUID.randomUUID().toString(); // Generated
        transaction.setTransactionAmount(withdrawRequestDto.getWithdrawAmount());
        transaction.setTransactionCode(uuid);

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(6L).get();
        transaction.setTransactionCategory(transactionCategory);


      return transactionRepository.save(transaction);

    }

    public Transaction depositTransaction(DepositRequestDto depositRequestDto) {

        Transaction transaction = new Transaction();

        transaction.setCreatedOn(new Date());

        // Transaction Type & Withdraw are saved on both way
        TransactionType transactionType = transactionTypeRepository.findById(7L).get();

        transaction.setTransactionType(transactionType);
        String uuid = UUID.randomUUID().toString();
        transaction.setTransactionAmount(depositRequestDto.getDepositAmount());
        transaction.setTransactionCode(uuid);

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(6L).get();
        transaction.setTransactionCategory(transactionCategory);

        return transactionRepository.save(transaction);

    }

    public ResponseDto updateTransaction(TransactionRequestDto transactionRequestDto, Long id) {

        Transaction transaction = transactionRepository.findById(id).get();

        transaction.setTransactionAmount(transactionRequestDto.getTransactionAmount());
        transaction.setTransactionCode(transactionRequestDto.getTransactionCode());
    //    transaction.setUpdatedOn(new Date());
        transaction.setCreatedOn(new Date());

        transactionRepository.save(transaction);
        return new ResponseDto(true, "update successes");
    }

    public ResponseDto deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
        return new ResponseDto(true, "deleted");
    }

    public List<Transaction> ListAllTransaction() {
        List<TransactionResponseDto> transactionResponseDtoArrayList = new ArrayList<>();
        return (List<Transaction>) transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id){
        return transactionRepository.findById(id).get();
    }

}
