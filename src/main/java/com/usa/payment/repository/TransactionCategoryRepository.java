package com.usa.payment.repository;


import com.usa.payment.model.TransactionCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCategoryRepository extends CrudRepository<TransactionCategory, Long> {
}