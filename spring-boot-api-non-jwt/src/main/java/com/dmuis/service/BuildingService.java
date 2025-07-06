package com.dmuis.service;

import java.util.List;

import com.dmuis.dto.response.BuildingResponseDTO;

public interface BuildingService {
	List<BuildingResponseDTO> findAll(String name, Long districtId);
}
