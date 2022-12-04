package com.usa.payment.Dto;

import com.usa.payment.model.Account;
import com.usa.payment.model.Transaction;
import com.usa.payment.model.TransactionCategory;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepositRequestDto {

    private Long depositedToId;

    private Long transactionId;

    private String depositedFrom;

    private Float depositAmount;

    private Date createdOn;

    private Date updatedOn;

    private Long transactionCategoryId;


}
