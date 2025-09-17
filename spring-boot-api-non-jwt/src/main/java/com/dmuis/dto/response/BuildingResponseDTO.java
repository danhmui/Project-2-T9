package com.dmuis.dto.response;

import java.util.List;

public class BuildingResponseDTO {
	private Long id;
	private String nameBuilding;
	private String address;
	private Long numberOfBasement;
	private String managerName;
	private String managerPhoneNumber;
	private Long floorArea;
	private Long emptyArea;
	private List<Long> rentArea;
	private Long rentPrice;
	private Long serviceFee;
	private Long brokerFee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameBuilding() {
		return nameBuilding;
	}
	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public Long getEmptyArea() {
		return emptyArea;
	}
	public void setEmptyArea(Long emptyArea) {
		this.emptyArea = emptyArea;
	}
	public List<Long> getRentArea() {
		return rentArea;
	}
	public void setRentArea(List<Long> rentArea) {
		this.rentArea = rentArea;
	}
	public Long getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Long getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Long getBrokerFee() {
		return brokerFee;
	}
	public void setBrokerFee(Long brokerFee) {
		this.brokerFee = brokerFee;
	}
	
}