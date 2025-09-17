package com.dmuis.dto;

import java.util.List;

public class BuildingDTO {
	private Long districtId;
	private Long staffId;
	private List<Integer> rentArea;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private List<String> typeCode; 	
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public List<Integer> getRentArea() {
		return rentArea;
	}
	public void setRentArea(List<Integer> rentArea) {
		this.rentArea = rentArea;
	}
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(Long rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(Long rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
	}
	public List<String> getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(List<String> typeCode) {
		this.typeCode = typeCode;
	}
}
