package com.example.storageApp.controller;

import com.example.storageApp.dto.TransactionDTO;
import com.example.storageApp.model.Suppliers;
import com.example.storageApp.model.Transactions;
import com.example.storageApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionsService;

    @GetMapping("/{ttype}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByType(@PathVariable String ttype) {
        List<TransactionDTO> transactions = transactionsService.getTransactionsByType(ttype);
        if (transactions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
        try {
            Transactions savedTransaction = transactionsService.createTransaction(transaction);
            return ResponseEntity.ok(savedTransaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Integer id) {
        try {
            transactionsService.softDeleteTransactions(id);
            return ResponseEntity.ok("Transaction deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
