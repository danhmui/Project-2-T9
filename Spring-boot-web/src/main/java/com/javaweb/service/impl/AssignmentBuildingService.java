package com.javaweb.service.impl;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IAssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AssignmentBuildingService implements IAssignmentBuildingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Override
    public List<StaffResponseDTO> getListStaff(Long buildingId) {
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1L, "STAFF");
        List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findByBuildingId(buildingId);
        List<Long> assignStaffs = assignmentBuildingEntities.stream()
                .map(item -> item.getStaffId())
                .collect(Collectors.toList());
        List<StaffResponseDTO> staffResponseDTOs = new ArrayList<>();
        for (UserEntity userEntity : staffs){
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setStaffId(userEntity.getId());
            staffResponseDTO.setFullName(userEntity.getFullName());
            if(assignStaffs.contains(userEntity.getId())) {
                staffResponseDTO.setChecked("checked");
            }else{
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOs.add(staffResponseDTO);
        }

        return staffResponseDTOs;
    }
}
