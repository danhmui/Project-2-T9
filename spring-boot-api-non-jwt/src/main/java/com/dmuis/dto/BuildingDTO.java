package com.dmuis.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingDTO {
	private String name;
	@JsonProperty("districtId")
	private Long district_id;
	private String ward;
	private String street;
	private Long numberOfBasement;
	private List<String> typeCode;
	public List<String> getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(List<String> typeCode) {
		this.typeCode = typeCode;
	}
	public Long getDistrictId() {
		return district_id;
	}
	public void setDistrictId(Long districtId) {
		this.district_id = districtId;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
}
