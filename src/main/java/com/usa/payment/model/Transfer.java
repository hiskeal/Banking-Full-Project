package com.usa.payment.model;

import java.time.Instant;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id",  nullable = false)
    private Account account;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Instant updatedOn;


}
