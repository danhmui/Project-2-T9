package com.javaweb.service.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.dto.ContactDTO;
import com.javaweb.dto.CustomerResponseDTO;
import com.javaweb.entity.AssignmentCustomerEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.StatusCode;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.AssignmentCustomerRepository;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.custom.impl.CustomerRepositoryCustomImpl;
import com.javaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private AssignmentCustomerRepository assignmentCustomerRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerRepositoryCustomImpl  customerRepositoryCustom;
    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public CustomerEntity contact(ContactDTO contactDTO) throws MyException {
        if(customerRepository.existsByPhoneContains(contactDTO.getPhone()))
            throw new MyException("Số điện thoai đã được liên hệ !");
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail(contactDTO.getEmail());
        customerEntity.setPhone(contactDTO.getPhone());
        customerEntity.setFullName(contactDTO.getFullName());
        customerEntity.setIsActive(true);
        customerEntity.setDemand(contactDTO.getDemand());
        customerEntity.setStatus(String.valueOf(StatusCode.CHUA_XU_LY));
        customerRepository.save(customerEntity);
        return customerEntity;
    }

    @Override
    public List<CustomerResponseDTO> findAll(CustomerSearchRequest params, Pageable pageable) {
        CustomerSearchBuilder builder = customerConverter.toCustomerSearchBuilder(params);
        List<CustomerEntity> customerEntities = customerRepositoryCustom.findAll(builder, pageable);
        List<CustomerResponseDTO> list = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            CustomerResponseDTO customerReponseDTO = customerConverter.toCustomerResponseDTO(customerEntity);
            list.add(customerReponseDTO);
        }
        return list;
    }

    @Override
    public int countTotalItem() {
        return customerRepositoryCustom.countTotalItem();
    }

    @Transactional
    @Override
    public void updateAssignment(AssignmentCustomerDTO assignmentCustomerDTO) {
        CustomerEntity customerEntity = customerRepository.findCustomerEntityById(assignmentCustomerDTO.getCustomerId());
        if(customerEntity != null){
            assignmentCustomerRepository.deleteByCustomer(customerEntity);
            if(assignmentCustomerDTO.getStaffIds() != null && !assignmentCustomerDTO.getStaffIds().isEmpty()){
                for (Long staffId : assignmentCustomerDTO.getStaffIds()) {
                    AssignmentCustomerEntity assignmentCustomerEntity = new AssignmentCustomerEntity();
                    assignmentCustomerEntity.setCustomer(customerEntity);
                    assignmentCustomerEntity.setStaffId(staffId);
                    assignmentCustomerRepository.save(assignmentCustomerEntity);
                }
            }
        }
    }

    @Override
    public CustomerDTO findCustomerByIdAndIsActive(Long id, Boolean active) {
        CustomerEntity customerEntity = customerRepository.findCustomerEntityByIdAndIsActive(id, true);
        CustomerDTO customerDTO = customerConverter.toCustomerDTO(customerEntity);
        return customerDTO;
    }

    @Override
    public CustomerResponseDTO addOrEditCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity;
        if(customerDTO.getId() != null){
            customerEntity = customerRepository.findCustomerEntityByIdAndIsActive(customerDTO.getId(), true);
            customerEntity.setFullName(customerDTO.getFullName());
            customerEntity.setPhone(customerDTO.getPhone());
            customerEntity.setEmail(customerDTO.getEmail());
            customerEntity.setCompanyName(customerDTO.getCompanyName());
            customerEntity.setDemand(customerDTO.getDemand());
            customerEntity.setStatus(customerDTO.getStatus());
        }else{
            customerEntity = customerConverter.toCustomerEntity(customerDTO);
            customerEntity.setIsActive(true);
            if (customerDTO.getStatus() == null || customerDTO.getStatus().trim().isEmpty()) {
                customerEntity.setStatus(StatusCode.CHUA_XU_LY.toString());
            }
        }
        customerRepository.save(customerEntity);
        CustomerResponseDTO customerResponseDTO = customerConverter.toCustomerResponseDTO(customerEntity);
        return customerResponseDTO;
    }

    @Transactional
    @Override
    public void deleteCustomers(List<Long> ids) {
        List<CustomerEntity> customerEntities = customerRepository.findAllById(ids);
        for (CustomerEntity customerEntity : customerEntities) {
            customerEntity.setIsActive(false);
        }
        customerRepository.saveAll(customerEntities);
    }
}
