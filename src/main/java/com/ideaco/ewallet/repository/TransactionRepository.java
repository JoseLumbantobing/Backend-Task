package com.ideaco.ewallet.repository;

import com.ideaco.ewallet.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {
    Optional<TransactionModel> findByTransactionSender(int transactionSender);
}
