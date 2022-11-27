package com.usa.payment.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawRequestDto {

    private Long accountId;

    private Date createdOn;

    private Long transactionId;

    private Date updatedOn;

    private float withdrawAmount;


}
