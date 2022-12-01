package com.usa.payment.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionTypeResponseDto {

    private Long id;
    private String description;

    private String type;

}
