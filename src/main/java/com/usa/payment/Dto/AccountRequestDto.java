package com.usa.payment.Dto;


import com.usa.payment.model.Person;
import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {

    private float balance;

    private Long personId;

    private Instant updatedOn;

    private Date createdOn;


}
