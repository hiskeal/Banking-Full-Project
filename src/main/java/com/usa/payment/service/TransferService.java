package com.usa.payment.service;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransferRequestDto;
import com.usa.payment.Dto.TransferResponseDto;
import com.usa.payment.model.Account;
import com.usa.payment.model.Transfer;
import com.usa.payment.repository.AccountRepository;
import com.usa.payment.repository.TransferRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseDto saveTransfer(TransferRequestDto transferRequestDto){

        Account account = accountRepository.findById(transferRequestDto.getAccountId()).get();
        if(account==null) {
            return new ResponseDto(false, "account does not exist");
        }
        Transfer transfer = new Transfer();

        transfer.setAccount(account);
        transfer.setCreatedOn(new Date());
        transfer.setUpdatedOn(Instant.now());
        transferRepository.save(transfer);
        return new ResponseDto(true, "created transfer");
    }

    public ResponseDto updateTransfer(TransferRequestDto transferRequestDto, Long id){

        Transfer transfer =  transferRepository.findById(id).get();
        Account account = accountRepository.findById(transferRequestDto.getAccountId()).get();
        transfer.setAccount(account);
        transfer.setUpdatedOn(Instant.now());

        transferRepository.save(transfer);

        return new ResponseDto(true,"Updated transfer success");
    }

    public ResponseDto deleteTransferById(Long id){
        transferRepository.deleteById(id);
        return new ResponseDto(true,"deleted by id success");
    }

    public ResponseDto deleteTransferById(Transfer transfer, Long id){
        transferRepository.delete(transfer);
        return new ResponseDto(true,"deleted by id success");
    }

    public Transfer getTransferById(Long id){
      return transferRepository.findById(id).get();
    }

    public List<Transfer> ListAll(){
        List<TransferResponseDto> transferResponseDto = new ArrayList<>();
        return (List<Transfer>) transferRepository.findAll();
    }

}
