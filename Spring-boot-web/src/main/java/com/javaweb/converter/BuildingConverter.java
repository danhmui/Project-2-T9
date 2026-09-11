package com.javaweb.converter;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.DistrictEntity;
import com.javaweb.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper  modelMapper;
    public BuildingResponseDTO convert(BuildingEntity buildingEntity){
        BuildingResponseDTO buildingResponseDTO =
                modelMapper.map(buildingEntity, BuildingResponseDTO.class);

        buildingResponseDTO.setAddress(buildingEntity.getStreet() + "," + buildingEntity.getWard()
                + "," + buildingEntity.getDistrict());
        List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreaEntities();
        String rentArea = rentAreaEntities.stream().map(i -> i.getValue().toString()).collect(Collectors.joining(","));
        buildingResponseDTO.setRentArea(rentArea);
        return buildingResponseDTO;
    }
}
