package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
    private String name;
    private Long floorArea;
    private String ward;
    private String street;
    private Long districtId;
    private Long numberOfBasement;
    private List<String> typeCode = new ArrayList<String>();
    private String managerName;
    private String managerPhoneNumber;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private Long areaFrom;
    private Long areaTo;
    private Long staffId;

    public String getName() {
        return name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public Long getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Long getRentPriceTo() {
        return rentPriceTo;
    }

    public Long getAreaTo() {
        return areaTo;
    }

    public Long getAreaFrom() {
        return areaFrom;
    }

    public Long getStaffId() {
        return staffId;
    }
    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.ward = builder.ward;
        this.street = builder.street;
        this.districtId = builder.districtId;
        this.numberOfBasement = builder.numberOfBasement;
        this.typeCode = builder.typeCode;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.staffId = builder.staffId;
    }

    public static class Builder {
        private String name;
        private Long floorArea;
        private String ward;
        private String street;
        private Long districtId;
        private Long numberOfBasement;
        private List<String> typeCode = new ArrayList<String>();
        private String managerName;
        private String managerPhoneNumber;
        private Long rentPriceFrom;
        private Long rentPriceTo;
        private Long areaFrom;
        private Long areaTo;
        private Long staffId;


        public void setName(String name) {
            this.name = name;
        }

        public void setFloorArea(Long floorArea) {
            this.floorArea = floorArea;
        }

        public void setWard(String ward) {
            this.ward = ward;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setDistrictId(Long districtId) {
            this.districtId = districtId;
        }

        public void setNumberOfBasement(Long numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
        }

        public void setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public void setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
        }

        public void setRentPriceFrom(Long rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
        }

        public void setRentPriceTo(Long rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
        }

        public void setAreaFrom(Long areaFrom) {
            this.areaFrom = areaFrom;
        }

        public void setAreaTo(Long areaTo) {
            this.areaTo = areaTo;
        }

        public void setStaffId(Long staffId) {
            this.staffId = staffId;
        }
        public BuildingSearchBuilder build(){
            return new BuildingSearchBuilder(this);
        }
    }
}
