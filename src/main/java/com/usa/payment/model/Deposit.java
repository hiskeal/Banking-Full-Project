package com.usa.payment.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "deposited_to_id")
    private Account depositedTo;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "transaction_category_id")
    private TransactionCategory transactionCategory;

    @Column(name= "deposited_from")
    private String depositedFrom;

    @Column(name= "deposited_amount")
    private Float depositAmount;

    @Column(name= "created_on")
    private Date createdOn;

    @Column(name= "updated_on")
    private Date updatedOn;


}
