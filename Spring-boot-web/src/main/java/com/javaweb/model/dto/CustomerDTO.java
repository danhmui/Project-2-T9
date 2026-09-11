package com.javaweb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CustomerDTO extends AbstractDTO{
    @NotEmpty
    private String fullName;
    private String managementStaff;
    @NotEmpty
    private String phone;
    private String email;
    private String demand;
    @NotEmpty
    private String status;
    private String companyName;
}
