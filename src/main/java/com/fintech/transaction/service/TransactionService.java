package com.fintech.transaction.service;

import com.fintech.transaction.model.Transaction;
import com.fintech.transaction.model.TransactionStatus;
import com.fintech.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        log.info("Creating new transaction from {} to {}", 
                 transaction.getFromAccount(), transaction.getToAccount());
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Cacheable(value = "transactions", key = "#id")
    public Transaction getTransactionById(String id) {
        log.info("Fetching transaction by ID: {}", id);
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + id));
    }

    public List<Transaction> getAllTransactions() {
        log.info("Fetching all transactions");
        return transactionRepository.findAll();
    }

    @Transactional
    @CacheEvict(value = "transactions", key = "#id")
    public Transaction updateTransactionStatus(String id, TransactionStatus status) {
        log.info("Updating transaction {} status to {}", id, status);
        Transaction transaction = getTransactionById(id);
        transaction.setStatus(status);
        return transactionRepository.save(transaction);
    }

    @Transactional
    @CacheEvict(value = "transactions", key = "#id")
    public void deleteTransaction(String id) {
        log.info("Deleting transaction: {}", id);
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionsByFromAccount(String account) {
        log.info("Fetching transactions from account: {}", account);
        return transactionRepository.findByFromAccount(account);
    }

    public List<Transaction> getTransactionsByStatus(TransactionStatus status) {
        log.info("Fetching transactions with status: {}", status);
        return transactionRepository.findByStatus(status);
    }
}