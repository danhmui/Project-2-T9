package com.javaweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuildingResponseDTO {
    private Long id;
    private String buildingName;
    private String address;
    private Integer numberOfBasement;
    private String managerName;
    private String managerPhone;
    private Long floorArea;
    private String rentArea;
    private Long rentPrice;

}
