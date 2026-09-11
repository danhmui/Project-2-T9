package com.javaweb.builder;

import java.util.List;


public class BuildingSearchBuilder {
    private String name;
    private Long floorArea;
    private List<String> typeCode;
    private String ward;
    private String street;
    private String district;
    private Integer numberOfBasement;
    private String direction;
    private String level;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private Long rentAreaFrom;
    private Long rentAreaTo;
    private String managerName;
    private String managerPhone;
    private Long staffId;

    public String getName() {
        return name;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public String getWard() {
        return ward;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getStreet() {
        return street;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public Long getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Long getRentPriceTo() {
        return rentPriceTo;
    }

    public Long getRentAreaFrom() {
        return rentAreaFrom;
    }

    public Long getRentAreaTo() {
        return rentAreaTo;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public Long getStaffId() {
        return staffId;
    }

    public String getDistrict() {
        return district;
    }

    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.typeCode = builder.typeCode;
        this.ward = builder.ward;
        this.street = builder.street;
        this.numberOfBasement = builder.numberOfBasement;
        this.direction = builder.direction;
        this.level = builder.level;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.rentAreaFrom = builder.rentAreaFrom;
        this.rentAreaTo = builder.rentAreaTo;
        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.staffId = builder.staffId;
        this.district = builder.district;
    }

    public static class Builder{
        private String name;
        private Long floorArea;
        private List<String> typeCode;
        private String ward;
        private String street;
        private String district;
        private Integer numberOfBasement;
        private String direction;
        private String level;
        private Long rentPriceFrom;
        private Long rentPriceTo;
        private Long rentAreaFrom;
        private Long rentAreaTo;
        private String managerName;
        private String managerPhone;
        private Long staffId;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFloorArea(Long floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setRentPriceFrom(Long rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder setRentPriceTo(Long rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public Builder setRentAreaFrom(Long rentAreaFrom) {
            this.rentAreaFrom = rentAreaFrom;
            return this;
        }

        public Builder setRentAreaTo(Long rentAreaTo) {
            this.rentAreaTo = rentAreaTo;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhone(String managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public BuildingSearchBuilder build(){
            return new BuildingSearchBuilder(this);
        }
    }
}