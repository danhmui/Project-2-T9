package com.javaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffResponseDTO {
    private Long id;
    private String userName;
    private String fullName;
    private String checked;
}
