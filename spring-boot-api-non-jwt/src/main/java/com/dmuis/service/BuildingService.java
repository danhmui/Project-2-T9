package com.dmuis.service;

import java.util.List;
import java.util.Map;

import com.dmuis.dto.BuildingDTO;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.entity.BuildingEntity;

public interface BuildingService {
	List<BuildingResponseDTO> findAll(List<String> typeCode, Map<String, Object> requestParams);
	BuildingEntity createBuilding(BuildingDTO buildingDTO);
	BuildingEntity updateBuilding(BuildingDTO buildingDTO);
	void deleteById(List<Long> ids);
}