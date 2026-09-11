package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
    @Column(name = "fullname", nullable = false)
    private String fullName;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "demand")
    private String demand;
    @Column(name = "status")
    private String status;
    @Column(name = "companyname")
    private String companyName;


    @OneToMany(mappedBy = "customerEntity")
    private List<TransactionEntity> transactionEntities = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentcustomer",
        joinColumns = @JoinColumn(name = "customerid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private List<UserEntity> userEntities = new ArrayList<>();
}
