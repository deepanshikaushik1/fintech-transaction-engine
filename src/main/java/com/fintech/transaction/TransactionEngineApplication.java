package com.fintech.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TransactionEngineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionEngineApplication.class, args);
        System.out.println("🚀 Fintech Transaction Engine is running!");
        System.out.println("📊 H2 Console: http://localhost:8080/h2-console");
        System.out.println("📚 API Base: http://localhost:8080/api/v1/transactions");
    }
}