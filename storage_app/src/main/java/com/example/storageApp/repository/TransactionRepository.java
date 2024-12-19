package com.example.storageApp.repository;

import com.example.storageApp.dto.TransactionDTO;
import com.example.storageApp.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
    @Query("SELECT new com.example.storageApp.dto.TransactionDTO(" +
            "t.tid, " +
            "t.products.pname, " +
            "t.users.uname, " +
            "t.suppliers.sname, " +
            "t.ttype, " +
            "t.tquantity, " +
            "t.tnote, " +
            "t.tdate, " +
            "t.tstatus) " +
            "FROM Transactions t " +
            "WHERE t.ttype = :ttype AND t.tstatus = 1")
    List<TransactionDTO> findTransactionsByType(@Param("ttype") String ttype);
}

