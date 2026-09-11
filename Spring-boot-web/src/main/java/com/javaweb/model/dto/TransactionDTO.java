package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TransactionDTO extends AbstractDTO{
    @NotBlank(message = "Note không thể thiếu")
    private String note;
    @NotBlank(message = "Code không thể thiếu")
    private String code;
    private Long staffId;
    @NotNull(message = "CustomerId không thể thiếu !")
    private Long customerId;
}
