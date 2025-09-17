package com.dmuis.repository.entity;

import java.util.List;

public class BuildingEntity {
	private Long id;
	private String name;
	private String street;
	private String ward;
	private Long districtid;
	private Long numberofbasement;
	private Long floorarea;
	private Long rentprice;
	private Long rentpricedescription;
	private String managername;
	private String managerphonenumber;
	private List<String> rentArea;
	public List<String> getRentArea() {
		return rentArea;
	}
	public void setRentArea(List<String> rentArea) {
		this.rentArea = rentArea;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Long getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Long numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public Long getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Long floorarea) {
		this.floorarea = floorarea;
	}
	public Long getRentprice() {
		return rentprice;
	}
	public void setRentprice(Long rentprice) {
		this.rentprice = rentprice;
	}
	public Long getRentpricedescription() {
		return rentpricedescription;
	}
	public void setRentpricedescription(Long rentpricedescription) {
		this.rentpricedescription = rentpricedescription;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}

	public Long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
}
