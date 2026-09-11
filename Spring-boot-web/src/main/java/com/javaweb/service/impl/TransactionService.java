package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionConverter transactionConverter;

    @Override
    public List<TransactionDTO> findAllByCodeAndCustomer(String code, Long id) {
        CustomerEntity customerEntity = customerRepository.findCustomerEntityById(id);
        List<TransactionEntity> transactionEntities = transactionRepository.findAllByCodeAndCustomerEntity(code, customerEntity);
        List<TransactionDTO> results = new ArrayList<>();
        for (TransactionEntity transactionEntity : transactionEntities) {
            TransactionDTO transactionDTO = transactionConverter.toTransactionDTO(transactionEntity);
            results.add(transactionDTO);
        }
        return results;
    }

    @Override
    public void createOrUpdateTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity;
        if(transactionDTO.getId() != null){
            transactionEntity = transactionRepository.findTransactionEntityById(transactionDTO.getId());
            transactionEntity.setNote(transactionDTO.getNote());
        }
        else{
            transactionEntity =  transactionConverter.toTransactionEntity(transactionDTO);
        }
        transactionRepository.save(transactionEntity);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
