package com.dmuis.repository;

import java.util.List;
import java.util.Map;

import com.dmuis.repository.entity.BuildingEntity;

public interface BuildingRepository{
	List<BuildingEntity> findAll(List<String> typeCode, Map<String, Object> requestParams);
}