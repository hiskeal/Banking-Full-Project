package com.usa.payment.service;


import com.usa.payment.Dto.*;
import com.usa.payment.model.Account;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.Transfer;
import com.usa.payment.model.Withdraw;
import com.usa.payment.repository.AccountRepository;
import com.usa.payment.repository.TransactionRepository;
import com.usa.payment.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WithdrawService {

    @Autowired
    private WithdrawRepository withdrawRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseDto saveWithdraw(WithdrawRequestDto withdrawRequestDto) {

        Withdraw withdraw = new Withdraw();
        Account account = accountRepository.findById(withdrawRequestDto.getAccountId()).get();

        Transaction transaction = transactionRepository.findById(withdrawRequestDto.getTransactionId()).get();


        withdraw.setAccount(account);
        withdraw.setTransaction(transaction);

        withdraw.setWithdrawAmount(withdrawRequestDto.getWithdrawAmount());
        withdraw.setCreatedOn(new Date());
        withdraw.setUpdatedOn(new Date());

        withdrawRepository.save(withdraw);
        return new ResponseDto(true, "withdraw fully created");
    }

    public ResponseDto updateWithdraw(WithdrawRequestDto withdrawRequestDto, Long id) {

        Withdraw withdraw = withdrawRepository.findById(id).get();
        Account account = accountRepository.findById(withdrawRequestDto.getAccountId()).get();
        Transaction transaction = transactionRepository.findById(withdrawRequestDto.getTransactionId()).get();

        withdraw.setAccount(account);
        withdraw.setTransaction(transaction);
        withdraw.setWithdrawAmount(withdrawRequestDto.getWithdrawAmount());
        withdraw.setUpdatedOn(new Date());


        withdrawRepository.save(withdraw);
        return new ResponseDto(true, "withdraw updated");
    }

    public ResponseDto deleteWithdrawById(Long withdrawId) {
        withdrawRepository.deleteById(withdrawId);
        return new ResponseDto(true, "deleted");
    }

    public List<Withdraw> ListAll(){
        List<WithdrawResponseDto> withdrawResponseDto = new ArrayList<>();
        return (List<Withdraw>) withdrawRepository.findAll();
    }

    public Withdraw getWithdrawById(Long id){
        return withdrawRepository.findById(id).get();
    }

}
