package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.service.IBuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    private BuildingRepositoryCustom buildingRepositoryCustom;

//    @Autowired
//    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BuildingResponseDTO> findAll(Map<String, Object> requestParams, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(requestParams, typeCode);
        List<BuildingEntity> buildingEntities = buildingRepositoryCustom.findAll(buildingSearchBuilder);
        List<BuildingResponseDTO> buildingResponseDTOS = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingResponseDTO buildingResponseDTO = modelMapper.map(buildingEntity, BuildingResponseDTO.class);
            buildingResponseDTOS.add(buildingResponseDTO);
        }
        return buildingResponseDTOS;
    }

//    @Override
//    public BuildingResponseDTO createBuilding(BuildingDTO buildingDTO) {
//        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
//        BuildingEntity buildingSave = buildingRepository.save(buildingEntity);
//        BuildingResponseDTO responseDTO = modelMapper.map(buildingSave, BuildingResponseDTO.class);
//        return responseDTO;
//    }
}
