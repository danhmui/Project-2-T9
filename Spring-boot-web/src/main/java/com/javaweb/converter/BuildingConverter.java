package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.utils.DistrictCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BuildingRepository buildingRepository;

    public BuildingResponseDTO toBuildingResponseDTO(BuildingEntity  buildingEntity){
        BuildingResponseDTO buildingResponseDTO = modelMapper.map(buildingEntity, BuildingResponseDTO.class);

        StringBuilder temp = new StringBuilder();
        if(buildingEntity.getDistrict() != null) {
            DistrictCode districtCode = DistrictCode.valueOf(buildingEntity.getDistrict());
            temp.append(districtCode.getDistrictName());
        }
        buildingResponseDTO.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() +  ", " + temp.toString());

        List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreaEntities();
        String rentArea = rentAreaEntities.stream().map(i -> i.getValue().toString()).collect(Collectors.joining(","));
        buildingResponseDTO.setRentArea(rentArea);
        return buildingResponseDTO;
    }

    public BuildingEntity toBuildingEntity(BuildingDTO buildingDTO){
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        String typeStr = buildingDTO.getType().stream().map(i -> i.toString()).collect(Collectors.joining(","));
        buildingEntity.setType(typeStr);
        if(buildingDTO.getId() != null){
            BuildingEntity buildingImage = buildingRepository.findBuildingEntityById(buildingDTO.getId());
            buildingEntity.setId(buildingImage.getId());
        }
        return buildingEntity;
    }

    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest request){
        BuildingSearchBuilder.Builder builder = new BuildingSearchBuilder.Builder();
        try {
            builder.setName(request.getName())
                    .setDistrict(request.getDistrict())
                    .setWard(request.getWard())
                    .setManagerName(request.getManagerName())
                    .setDirection(request.getDirection())
                    .setManagerPhone(request.getManagerPhone())
                    .setLevel(request.getLevel())
                    .setStreet(request.getStreet())
                    .setTypeCode(request.getTypeCode())
                    .setRentAreaFrom(request.getAreaFrom())
                    .setRentAreaTo(request.getAreaTo())
                    .setFloorArea(request.getFloorArea())
                    .setNumberOfBasement(request.getNumberOfBasement())
                    .setRentPriceFrom(request.getRentPriceFrom())
                    .setRentPriceTo(request.getRentPriceTo())
                    .setNumberOfBasement(request.getNumberOfBasement())
                    .setStaffId(request.getStaffId())
                    .setRentAreaFrom(request.getAreaFrom())
                    .setRentAreaTo(request.getAreaTo());
        }catch (Exception e){
            e.printStackTrace();
        }
        return builder.build();
    }
}
