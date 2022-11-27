package com.usa.payment.Dto;


import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDto {

    private String firstName;

    private String middleName;

    private String lastName;

    private int age;

    private String department;

    private Date dateOfBirth;

    private String address;

    private String email;

    private Long phoneNumber;
}
