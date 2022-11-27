package com.usa.payment.model;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "transaction_amount")
    private Float transactionAmount;

    @Column(name = "transaction_code")
    private String transactionCode;

    @Column(name = "updated_on")
    private Date updatedOn;



}
