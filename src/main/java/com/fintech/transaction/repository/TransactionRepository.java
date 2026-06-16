package com.fintech.transaction.repository;

import com.fintech.transaction.model.Transaction;
import com.fintech.transaction.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByStatus(TransactionStatus status);
    List<Transaction> findByFromAccount(String fromAccount);
    List<Transaction> findByToAccount(String toAccount);
}