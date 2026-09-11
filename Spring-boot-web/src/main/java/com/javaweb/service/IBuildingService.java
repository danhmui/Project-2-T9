package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {
    BuildingResponseDTO createOrUpdateBuilding(BuildingDTO buildingDTO);
    BuildingDTO findBuildingById(long id);
    void deleteBuildingEntityById(Long id);
    void deleteAllBuildingEntitiesByIdIn(List<Long> ids);
    void deleteAssignmentBuildingEntitiesByIdIn(Long id);
    void assignStaffs(Long buildingId, List<Long> staffIds);
    void updateAssignment(AssignmentBuildingDTO assignmentBuildingDTO);
    List<BuildingResponseDTO> findAll(BuildingSearchRequest params, Pageable pageable);
    int countTotalItem();

}
