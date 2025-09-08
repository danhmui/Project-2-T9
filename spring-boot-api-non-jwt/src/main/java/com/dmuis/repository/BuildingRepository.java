package com.dmuis.repository;

import java.util.List;

import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(String name, Long districtId);
}
