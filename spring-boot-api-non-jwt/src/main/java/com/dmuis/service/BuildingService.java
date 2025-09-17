package com.dmuis.service;

import java.util.List;
import java.util.Map;

import com.dmuis.dto.response.BuildingResponseDTO;

public interface BuildingService {
	List<BuildingResponseDTO> findAll(List<String> typeCode, Map<String, Object> requestParams);
}