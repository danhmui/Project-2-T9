package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum StatusCode {
    CHUA_XU_LY("Chưa xử lý"),
    DANG_XU_LY("Đang xử lý"),
    DA_XU_LY("Đã xử lý");

    private final String statusName;
    StatusCode(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public static Map<String, String> getStatusMap(){
        Map<String, String> statusList = new LinkedHashMap<>();
        for(StatusCode item : StatusCode.values()){
            statusList.put(item.toString(), item.getStatusName());
        }
        return statusList;
    }

}
