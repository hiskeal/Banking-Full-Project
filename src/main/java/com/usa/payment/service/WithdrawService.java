package com.usa.payment.service;


import com.usa.payment.Dto.*;
import com.usa.payment.model.Account;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.TransactionCategory;
import com.usa.payment.model.Withdraw;
import com.usa.payment.repository.AccountRepository;
import com.usa.payment.repository.TransactionCategoryRepository;
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
    private TransactionCategoryRepository transactionCategoryRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionService transactionService;
    public ResponseDto saveWithdraw(WithdrawRequestDto withdrawRequestDto) {

        Withdraw withdraw = new Withdraw();
        Account account = accountRepository.findById(withdrawRequestDto.getAccountId()).get();
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(withdrawRequestDto.getAccountId()).get();
        Transaction transaction1 = transactionRepository.findById(withdrawRequestDto.getTransactionId()).get(); // Transaction get from somebody by id.
        Transaction transaction = transactionService.withdrawTransaction(withdrawRequestDto); // we're adding

if(account.getBalance()<= withdrawRequestDto.getWithdrawAmount()) {
    return new ResponseDto(false, "my Balance is not enough");
}

    float balance = account.getBalance();
        System.out.println("my balance is " + balance);

    float withdrawAmount = balance - withdrawRequestDto.getWithdrawAmount();
        System.out.println("cash " + withdrawAmount);

    account.setBalance(withdrawAmount);

    accountRepository.save(account);

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
