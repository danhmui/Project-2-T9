package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode){
        BuildingSearchBuilder.Builder buildingSearchBuilder = new BuildingSearchBuilder.Builder();
        buildingSearchBuilder.setName(MapUtils.getObject(params.getOrDefault("name", null), String.class));
        buildingSearchBuilder.setDistrictId(MapUtils.getObject(params.getOrDefault("districtId", null), Long.class));
        buildingSearchBuilder.setAreaFrom(MapUtils.getObject(params.getOrDefault("rentareaFrom", null), Long.class));
        buildingSearchBuilder.setAreaTo(MapUtils.getObject(params.getOrDefault("rentAreaTo", null), Long.class));
        buildingSearchBuilder.setFloorArea(MapUtils.getObject(params.getOrDefault("floorArea", null), Long.class));
        buildingSearchBuilder.setManagerName(MapUtils.getObject(params.getOrDefault("managerName", null), String.class));
        buildingSearchBuilder.setManagerPhoneNumber(MapUtils.getObject(params.getOrDefault("managerPhoneNumber", null), String.class));
        buildingSearchBuilder.setTypeCode(typeCode);
        buildingSearchBuilder.setRentPriceFrom(MapUtils.getObject(params.getOrDefault("rentPriceFrom", null), Long.class));
        buildingSearchBuilder.setRentPriceTo(MapUtils.getObject(params.getOrDefault("rentPriceTo", null), Long.class));
        buildingSearchBuilder.setNumberOfBasement(MapUtils.getObject(params.getOrDefault("numberOfBasement", null), Long.class));
        buildingSearchBuilder.setStaffId(MapUtils.getObject(params.getOrDefault("staffId", null), Long.class));
        buildingSearchBuilder.setStreet(MapUtils.getObject(params.getOrDefault("street", null), String.class));
        buildingSearchBuilder.setWard(MapUtils.getObject(params.getOrDefault("ward", null), String.class));
        buildingSearchBuilder.build();

        return buildingSearchBuilder.build();
        }

}
