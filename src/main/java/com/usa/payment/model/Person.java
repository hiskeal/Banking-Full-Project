package com.usa.payment.model;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name")
    private String firstName;

//    @OneToMany
//    @JoinColumn(name = "account_id", nullable = false)
//    private Account account;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="address")
    private String address;

    @Column(name="department")
    private String department;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private Long phoneNumber;
}
