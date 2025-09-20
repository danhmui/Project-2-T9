package com.dmuis.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmuis.converter.BuildingConverter;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.DistrictRepository;
import com.dmuis.repository.RentAreaRepository;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.repository.entity.DistrictEntity;
import com.dmuis.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	
	@Override
	public List<BuildingResponseDTO> findAll(List<String> typeCode, Map<String, Object> requestParams) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(typeCode, requestParams);
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for(BuildingEntity it : buildingEntities ) {
			BuildingResponseDTO buildingResponseDTO = buildingConverter.toBuildingResponseDTO(it);
			results.add(buildingResponseDTO);
			
		}
		return results;
	}
	
}