package com.javaweb.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BuildingDTO extends AbstractDTO{
    @NotBlank(message = "Name can not be empty !")
    private Long id;

    private String name;
    private String street;
    private String ward;
    @NotBlank(message = "District can not be empty !")
    @JsonProperty("district_id")
    private String district;

    @Min(value = 1, message = "Number of basement must greater than 1 !")
    private Long numberOfBasement;

    private Long floorArea;
    private String level;

    @Size(min = 1)
    private List<String> typeCode;

    private String overtimeFee;
    private String electricityFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationTime;
    private String rentPriceDescription;
    private String carFee;
    private String motoFee;
    private String structure;
    private String direction;
    private String note;
    private String rentArea;
    private String managerName;
    private String managerPhone;

    @NotNull(message = "Rent price is required !")
    private Long rentPrice;

    private String serviceFee;
    private double brokerageFee;
    private String image;
    private String imageBase64;
    private String imageName;

    private Map<String,String> buildingDTOs = new HashMap<>();


    public String getImageBase64() {
        if (imageBase64 != null) {
            return imageBase64.split(",")[1];
        }
        return null;
    }

}