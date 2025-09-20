package com.dmuis.repository;

import com.dmuis.repository.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findById (Long id);
}
