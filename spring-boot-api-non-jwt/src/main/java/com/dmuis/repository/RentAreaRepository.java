package com.dmuis.repository;

import java.util.List;

public interface RentAreaRepository {
	List<Long> findAll(Long buildingId);
}
