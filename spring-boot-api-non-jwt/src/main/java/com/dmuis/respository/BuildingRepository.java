package com.dmuis.respository;
import java.util.List;
import com.dmuis.responsitory.entity.*;

public interface BuildingRepository {
	List<BuildingEntity> findAll(String name, Long districtId);
}
