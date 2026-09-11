package com.javaweb.repository;

import com.javaweb.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByPhoneContains(String phone);

    CustomerEntity findCustomerEntityByIdAndIsActive(Long id, Boolean active);

    void deleteByIdIn(Collection<Long> ids);

    CustomerEntity findCustomerEntityById(Long id);

    boolean existsByIdAndUserEntities_Id(Long customerId, Long staffId);
}
