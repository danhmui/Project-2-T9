package com.javaweb.service;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface ITransactionService {
    List<TransactionDTO> findAllByCodeAndCustomer(String code, Long id);
    void createOrUpdateTransaction(TransactionDTO transactionDTO);
    void deleteTransaction(Long id);
}
