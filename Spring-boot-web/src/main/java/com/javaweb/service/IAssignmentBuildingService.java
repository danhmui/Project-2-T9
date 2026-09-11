package com.javaweb.service;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.response.StaffResponseDTO;

import java.util.List;

public interface IAssignmentBuildingService {
    List<StaffResponseDTO> getListStaff(Long buildingId);
}
