package com.example.storageApp.service;

import com.example.storageApp.dto.TransactionDTO;
import com.example.storageApp.model.Transactions;
import com.example.storageApp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transactions createTransaction(Transactions transaction) {
        return transactionRepository.save(transaction);
    }

    public List<TransactionDTO> getTransactionsByType(String ttype) {
        return transactionRepository.findTransactionsByType(ttype);
    }

    public void softDeleteTransactions(Integer id) {
        Transactions existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));

        existingTransaction.setTstatus(0);
        transactionRepository.save(existingTransaction);
    }
}
