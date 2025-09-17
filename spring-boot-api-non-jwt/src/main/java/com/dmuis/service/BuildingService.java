package com.dmuis.service;

import java.util.List;
import java.util.Map;

import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.entity.BuildingEntity;

public interface BuildingService {
	List<BuildingResponseDTO> findAll(List<String> typeCode,
									List<String> rentArea,
									Map<String, Object> requestBuilding);
}
