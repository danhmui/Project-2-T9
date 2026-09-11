package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum DistrictType {
    QUAN_1("QUẬN 1"),
    QUAN_2("QUẬN 2"),
    QUAN_3("QUẬN 3"),
    QUAN_4("QUẬN 4"),
    QUAN_5("QUẬN 5"),
    QUAN_TD("QUẬN THỦ ĐỨC");

    private String name;

    DistrictType(String name){
        this.name = name;
    }

    public String getCode(){
        return this.name;
    }

    public static Map<String, String> getDistrict(){
        Map<String, String> district = new LinkedHashMap<>();
        for(DistrictType item : DistrictType.values()){
            district.put(item.name(), item.getCode());
        }
        return district;
    }
}
