package com.usa.payment.Dto;

import com.usa.payment.model.Account;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.TransactionCategory;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DepositResponseDto {

    private Long id;

    private Account depositedTo;

    private TransactionCategory transactionCategory;

    private Transaction transaction;


    private String depositedFrom;


    private Float depositAmount;


    private Date createdOn;


    private Date updatedOn;


}
