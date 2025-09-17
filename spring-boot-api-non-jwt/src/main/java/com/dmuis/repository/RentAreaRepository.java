package com.dmuis.repository;

import java.util.List;

public interface RentAreaRepository {
	List<Long> findValue (Long buildingId);
}