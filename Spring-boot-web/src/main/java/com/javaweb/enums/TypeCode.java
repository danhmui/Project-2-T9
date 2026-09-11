package com.javaweb.enums;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum TypeCode {
    TANG_TRET("Tầng Trệt"),
    NGUYEN_CAN("Nguyên Căn"),
    NOI_THAT("Nội Thất");

    private String name;

    TypeCode(String name){
        this.name = name;
    }
    public String getTypeName(){
        return this.name;
    }
    public static Map<String, String> getType(){
        Map<String, String> type = new LinkedHashMap<>();
        for(TypeCode item : TypeCode.values()){
            type.put(item.name(), item.getTypeName());
        }
        return type;
    }
}
