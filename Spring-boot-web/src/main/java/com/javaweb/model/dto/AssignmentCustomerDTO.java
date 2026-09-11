package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssignmentCustomerDTO {
    private List<Long> staffIds;
    private Long customerId;
}
