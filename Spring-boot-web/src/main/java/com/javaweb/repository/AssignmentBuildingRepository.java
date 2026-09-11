package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity, Long> {
    void deleteAssignmentBuildingEntityById(Long id);
    List<Long> findStaffIdByBuildingId(Long buildingId);

    void deleteByBuilding(BuildingEntity building);
    List<AssignmentBuildingEntity> findByBuildingId(Long buildingId);

    void deleteByBuilding_Id(Long id);
}
