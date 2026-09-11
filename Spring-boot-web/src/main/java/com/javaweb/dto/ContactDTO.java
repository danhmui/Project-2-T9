package com.javaweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ContactDTO {
    @JsonProperty("fullname")
    @NotBlank(message = "Họ và tên không được để trống !")
    private String fullName;
    private String email;
    @NotBlank(message = "Số điện thoại không được để trống !")
    private String phone;
    private String demand;
}
