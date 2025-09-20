package com.dmuis.repository;

import java.util.List;

import com.dmuis.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> findByBuildingId (Long buildingId);
}