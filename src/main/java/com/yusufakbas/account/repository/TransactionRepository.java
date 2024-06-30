package com.yusufakbas.account.repository;

import com.yusufakbas.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}