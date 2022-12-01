package com.usa.payment.service;


import com.usa.payment.Dto.ResponseDto;

import com.usa.payment.Dto.TransactionTypeRequestDto;
import com.usa.payment.model.TransactionType;
import com.usa.payment.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;


    public ResponseDto saveTransactionType(TransactionTypeRequestDto transactionTypeRequestDto) {

        TransactionType transactionType = new TransactionType();

        transactionType.setDescription(transactionTypeRequestDto.getDescription());
        transactionType.setType(transactionTypeRequestDto.getType());

        transactionTypeRepository.save(transactionType);
        return new ResponseDto(true, "Transaction Type Saved ");
    }

    public ResponseDto updateTransactionType(TransactionTypeRequestDto transactionTypeRequestDto, Long id) {

        TransactionType transactionType = transactionTypeRepository.findById(id).get();

        transactionType.setDescription(transactionTypeRequestDto.getDescription());
        transactionType.setType(transactionTypeRequestDto.getType());


        transactionTypeRepository.save(transactionType);
        return new ResponseDto(true, "TransactionType updated successes");
    }

    public ResponseDto deleteTransactionTypeById(Long id) {
        transactionTypeRepository.deleteById(id);
        return new ResponseDto(true, "deleted");
    }

    public List<TransactionType> ListAllTransactionType() {
        List<TransactionTypeRequestDto> transactionTypeRequestDtoList = new ArrayList<>();
        return (List<TransactionType>) transactionTypeRepository.findAll();
    }

    public TransactionType getTransactionTypeById(Long id){
        return transactionTypeRepository.findById(id).get();
    }

}
