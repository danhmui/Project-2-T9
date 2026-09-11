package com.javaweb.converter;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.dto.CustomerResponseDTO;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.StatusCode;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerConverter {
    @Autowired
    ModelMapper modelMapper;

    public CustomerSearchBuilder toCustomerSearchBuilder(CustomerSearchRequest request) {
        CustomerSearchBuilder.Builder builder = new CustomerSearchBuilder.Builder();
        try{
            builder.setFullName(request.getFullName())
                    .setEmail(request.getEmail())
                    .setPhone(request.getPhone())
                    .setStatus(request.getStatus())
                    .setStaffId(request.getStaffId());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return builder.build();
    }

    public CustomerResponseDTO toCustomerResponseDTO(CustomerEntity customerEntity){
        CustomerResponseDTO customerReponseDTO = modelMapper.map(customerEntity, CustomerResponseDTO.class );
        if(customerEntity.getStatus() != null && !customerEntity.getStatus().isEmpty()){
            StatusCode statusCode = StatusCode.valueOf(customerEntity.getStatus());
            customerReponseDTO.setStatus(statusCode.getStatusName());
        }
        return customerReponseDTO;
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity =  modelMapper.map(customerDTO, CustomerEntity.class);
        return customerEntity;
    }
}
