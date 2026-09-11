package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.service.impl.UserService;
import org.hibernate.validator.internal.constraintvalidators.bv.AssertTrueValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerConverter customerConverter;

    public TransactionDTO toTransactionDTO(TransactionEntity transactionEntity){
        TransactionDTO result = modelMapper.map(transactionEntity, TransactionDTO.class);
        result.setStaffId(transactionEntity.getUser().getId());
        return result;
    }
    public TransactionEntity toTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity result = modelMapper.map(transactionDTO, TransactionEntity.class);
        UserEntity userEntity = userConverter.convertToEntity(userService.findUserById(transactionDTO.getStaffId()));
        CustomerEntity customerEntity = customerConverter.toCustomerEntity(customerService.findCustomerByIdAndIsActive(transactionDTO.getCustomerId(), true));
        result.setUser(userEntity);
        result.setCustomerEntity(customerEntity);
        return result;
    }
}
