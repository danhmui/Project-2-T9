package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    List<BuildingEntity> findByNameContainingAndWardContainingAndTypeContaining(String buildingName, String buildingWard, String buildingType);
    BuildingEntity findBuildingEntityById(long id);
    void deleteBuildingEntityById(Long id);
    void deleteAllBuildingEntitiesByIdIn(List<Long> ids);
}
