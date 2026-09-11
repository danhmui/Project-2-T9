package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assignmentcustomer")
@Getter
@Setter
public class AssignmentCustomerEntity extends BaseEntity{
    @Column(name = "staffid", nullable = false)
    private Long staffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private CustomerEntity customer;
}
