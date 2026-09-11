package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BuildingDTO {
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String district;
    private Integer numberOfBasement;
    private Double floorArea;
    private Double rentPrice;
    private String rpDescription;
    private List<String> type;
    private String managerName;
    private String managerPhone;
    private String rentArea;
    private String structure;
    private String level;
    private String direction;
    private String imageBase64;
    private String imageName;

    private Map<String, String> buildingDTOS = new HashMap<>();

    public String getImageBase64(){
        if(imageBase64 != null)
            return imageBase64.split(",")[1];
        return null;
    }

}
