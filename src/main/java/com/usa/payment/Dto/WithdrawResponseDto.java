package com.usa.payment.Dto;


import com.usa.payment.model.Account;
import com.usa.payment.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawResponseDto {

    private Long id;

    private Account account;

    private Date createdOn;

    private Transaction transaction;

    private float withdrawAmount;

    private Instant updatedOn;
}
