package com.javaweb.enums;


import java.util.*;

public enum BuildingType {
    TANG_TRET ("Tầng Trệt "),
    NGUYEN_CAN ("Nguyên Căn "),
    NOI_THAT ("Nội Thất ");

    private final String buildingName;

    BuildingType(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public static Map<String,String> getBuildingTypeMap(){
        Map<String,String> listType = new HashMap<>();
        for(BuildingType item : BuildingType.values()){
            listType.put(item.toString() , item.getBuildingName());
        }
        return listType;
    }
}
