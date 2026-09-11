package com.javaweb.utils;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum     BuildingType {
    TANG_TRET ("Tầng Trệt "),
    NGUYEN_CAN ("Nguyên Căn "),
    NOI_THAT ("Nội Thất ");

    private final String typeName;

    BuildingType(String typeName) {
        this.typeName = typeName;
    }

    public String getCode() {
        return typeName;
    }

    public static Map<String,String> getBuildingType(){
        Map<String,String> listType = new LinkedHashMap<>();
        for(BuildingType item : BuildingType.values()){
            listType.put(item.name() , item.getCode());
        }
        return listType;
    }
}
