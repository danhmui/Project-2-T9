package com.javaweb.service;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode);
}
