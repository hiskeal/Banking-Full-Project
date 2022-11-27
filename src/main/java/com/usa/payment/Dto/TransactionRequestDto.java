package com.usa.payment.Dto;


import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {

    private Date createdOn;

    private float transactionAmount;

    private String transactionCode;

    private Date updatedOn;


}
