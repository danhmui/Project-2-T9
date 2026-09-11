package com.javaweb.service;

import com.javaweb.dto.*;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    CustomerEntity contact(ContactDTO contactDTO) throws MyException;
    List<CustomerResponseDTO> findAll(CustomerSearchRequest params, Pageable pageable);
    int countTotalItem();
    void updateAssignment(AssignmentCustomerDTO assignmentCustomerDTO);
    CustomerDTO findCustomerByIdAndIsActive(Long id, Boolean active);
    CustomerResponseDTO addOrEditCustomer(CustomerDTO customerDTO);
//    void deleteCustomer(Long id);
    void deleteCustomers(List<Long> ids);
}
