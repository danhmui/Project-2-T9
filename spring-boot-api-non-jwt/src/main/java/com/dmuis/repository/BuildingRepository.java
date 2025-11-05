package com.dmuis.repository;

import java.util.List;
import java.util.Map;

import com.dmuis.builder.BuildingSearchBuilder;
import com.dmuis.repository.entity.BuildingEntity;

public interface BuildingRepository{
	List<BuildingEntity> findAll(BuildingSearchBuilder builder);
}