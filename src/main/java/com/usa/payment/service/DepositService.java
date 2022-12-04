package com.usa.payment.service;

import com.usa.payment.Dto.DepositRequestDto;
import com.usa.payment.Dto.DepositResponseDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.*;
import com.usa.payment.repository.AccountRepository;
import com.usa.payment.repository.DepositRepository;
import com.usa.payment.repository.TransactionCategoryRepository;
import com.usa.payment.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepositService {

    @Autowired
   private DepositRepository depositRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;
    public ResponseDto saveDeposit(DepositRequestDto depositRequestDto) {


        Deposit deposit = new Deposit();

        deposit.setCreatedOn(new Date());
        deposit.setUpdatedOn(new Date());
        deposit.setDepositAmount(depositRequestDto.getDepositAmount());
        deposit.setDepositedFrom(depositRequestDto.getDepositedFrom());



        Transaction transaction = transactionService.depositTransaction(depositRequestDto);

        deposit.setTransaction(transaction);


   //     Transaction transaction1 = transactionRepository.findById(depositRequestDto.getTransactionId()).get();
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(depositRequestDto
                .getTransactionCategoryId()).get();

        deposit.setTransactionCategory(transactionCategory);


        Account account = accountRepository.findById(depositRequestDto.getDepositedToId()).get();

        // ACCOUNT ADDED CALCULATION
        float balance = account.getBalance();
        float depositAmount = balance + depositRequestDto.getDepositAmount();
        account.setBalance(depositAmount);
        deposit.setDepositedTo(account);


        depositRepository.save(deposit);
        return new ResponseDto(true, "Deposit Saved safely");
    }

    public ResponseDto updateDeposit(DepositRequestDto depositRequestDto, Long id) {

        Deposit deposit = depositRepository.findById(id).get();
        Transaction transaction = transactionRepository.findById(depositRequestDto.getTransactionId()).get();

        TransactionCategory transactionCategory = transactionCategoryRepository.findById(depositRequestDto
                .getTransactionCategoryId()).get();
        Account account = accountRepository.findById(depositRequestDto.getDepositedToId()).get();

        deposit.setCreatedOn(new Date());
        deposit.setDepositAmount(depositRequestDto.getDepositAmount());
        deposit.setDepositedFrom(depositRequestDto.getDepositedFrom());
        deposit.setDepositedTo(account);
        deposit.setTransaction(transaction);
        deposit.setTransactionCategory(transactionCategory);

        return new ResponseDto(true, "Updated Deposit safely");
    }

    public ResponseDto deleteDeposit(Long id) {
        depositRepository.deleteById(id);

        return new ResponseDto(true, "deleted By ID successfully");
    }

    public List<Deposit> ListAllDeposit() {
        List<DepositResponseDto> depositResponseDto = new ArrayList<>();
        return (List<Deposit>) depositRepository.findAll();
    }

    public Deposit getDepositById(Long id) {
       return depositRepository.findById(id).get();
    }
}
