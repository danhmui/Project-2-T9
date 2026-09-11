package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode){
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUtils.getObject(params.getOrDefault("name", null), String.class))
                .setDirection(MapUtils.getObject(params.getOrDefault("direction", null), String.class))
                .setManagerName(MapUtils.getObject(params.getOrDefault("managerName", null), String.class))
                .setLevel(MapUtils.getObject(params.getOrDefault("level", null), String.class))
                .setManagerPhone(MapUtils.getObject(params.getOrDefault("managerPhone", null), String.class))
                .setRentAreaFrom(MapUtils.getObject(params.getOrDefault("areaFrom", null), Long.class))
                .setRentAreaTo(MapUtils.getObject(params.getOrDefault("areaTo", null), Long.class))
                .setRentPriceTo(MapUtils.getObject(params.getOrDefault("rentPriceTo", null), Long.class))
                .setRentPriceFrom(MapUtils.getObject(params.getOrDefault("rentPriceFrom", null), Long.class))
                .setFloorArea(MapUtils.getObject(params.getOrDefault("floorArea", null), Long.class))
                .setStaffId(MapUtils.getObject(params.getOrDefault("staffId", null), Long.class))
                .setStreet(MapUtils.getObject(params.getOrDefault("street", null), String.class))
                .setWard(MapUtils.getObject(params.getOrDefault("ward", null), String.class))
                .setTypeCode(typeCode)
                .setDistrict(MapUtils.getObject(params.getOrDefault("district", null), String.class))
                .build();
        return buildingSearchBuilder;
    }
}
