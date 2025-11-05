package com.dmuis.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmuis.builder.BuildingSearchBuilder;
import com.dmuis.converter.BuildingConverter;
import com.dmuis.converter.BuildingSearchBuilderConverter;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@Override
	public List<BuildingResponseDTO> findAll(List<String> typeCode, Map<String, Object> requestParams) {
		BuildingSearchBuilder builder = buildingSearchBuilderConverter.toBuildingSearchBuilder(requestParams, typeCode);
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(builder);
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for(BuildingEntity it : buildingEntities ) {
			BuildingResponseDTO buildingResponseDTO = buildingConverter.toBuildingResponseDTO(it);
			results.add(buildingResponseDTO);
			
		}
		return results;
	}
	
}