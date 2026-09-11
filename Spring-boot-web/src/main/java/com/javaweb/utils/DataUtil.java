package com.javaweb.utils;

public class DataUtil {
    public static boolean checkData(Object data){
        if(data != null && data != "")
            return true;
        return false;
    }
}
