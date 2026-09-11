package com.javaweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegisterDTO {
    @NotBlank(message = "Username không được để trống !")
    private String userName;
    @NotBlank(message = "Mật khẩu không được để trống !")
    private String passWord;
    @NotBlank(message = "Họ và tên không được để trống !")
    private String fullName;
    @NotBlank(message = "Nhập lại mật khẩu không được để trống !")
    private String confirmPassword;
}
