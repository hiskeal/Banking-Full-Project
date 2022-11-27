package com.usa.payment.Dto;



import com.usa.payment.model.Account;
import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto {

    private Long id;

    private Date createdOn;

    private float transactionAmount;

    private String transactionCode;

    private Date updatedOn;
}
