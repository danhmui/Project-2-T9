package com.javaweb.dto;

import com.javaweb.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDTO extends BaseEntity {
    private String fullName;
    private String email;
    private String phone;
    private String status;
    private boolean isAcive;
    private String demand;
    private String companyName;
}
