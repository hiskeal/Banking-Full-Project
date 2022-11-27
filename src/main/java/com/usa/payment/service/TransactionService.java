package com.usa.payment.service;


import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransactionRequestDto;
import com.usa.payment.Dto.TransactionResponseDto;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.Transfer;
import com.usa.payment.repository.TransactionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseDto saveTransaction(TransactionRequestDto transactionRequestDto) {

        Transaction transaction = new Transaction();

        transaction.setTransactionAmount(transactionRequestDto.getTransactionAmount());
        transaction.setTransactionCode(transactionRequestDto.getTransactionCode());
        transaction.setCreatedOn(new Date());
        transaction.setUpdatedOn(new Date());

        transactionRepository.save(transaction);
        return new ResponseDto(true, "Transaction fully ");
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
