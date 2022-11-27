package com.usa.payment.repository;

import com.usa.payment.model.Transaction;
import com.usa.payment.model.Withdraw;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepository extends CrudRepository<Withdraw, Long> {
}
