package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentAreaRepository extends JpaRepository<RentAreaEntity,Long> {
    void deleteByBuildingEntity(BuildingEntity buildingEntity);
    void deleteByBuildingEntity_Id(Long id);
    List<RentAreaEntity>  findByBuildingEntity(BuildingEntity buildingEntity);
}
