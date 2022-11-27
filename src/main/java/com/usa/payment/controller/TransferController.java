package com.usa.payment.controller;

import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.Dto.TransferRequestDto;
import com.usa.payment.model.Transfer;
import com.usa.payment.service.TransferService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/saveTransfer")
    public ResponseDto saveTransfer(@RequestBody TransferRequestDto transferRequestDto) {
        return  transferService.saveTransfer(transferRequestDto);

    }

    @PutMapping("/updateTransfer/{id}")
    public ResponseDto updateTransfer(@RequestBody TransferRequestDto transferRequestDto, @PathVariable Long id) {
       return  transferService.updateTransfer(transferRequestDto, id);

    }

    @DeleteMapping("/deleteTransfer/{id}")
    public ResponseDto deleteTransfer(@PathVariable("id") Long id) {
        return  transferService.deleteTransferById(id);


    }

    @GetMapping("/listTransfer")
    public List<Transfer> ListAllTrasfer() {
        return transferService.ListAll();
    }

    @GetMapping("/getTransfer/{id}")
    public Transfer getTransferById(@PathVariable Long id) {
         return transferService.getTransferById(id);
    }


}
