package com.javaweb.utils;

import java.util.List;

public class DataUtils {

    public static boolean checkData(Object value){
        if(value == null) return false;

        if(value instanceof String){
            return !((String) value).trim().equals("");
        }

        if(value instanceof List){
            return !((List<?>) value).isEmpty();
        }

        return true;
    }
}
