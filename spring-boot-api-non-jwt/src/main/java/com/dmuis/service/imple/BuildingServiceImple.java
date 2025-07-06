package com.dmuis.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.responsitory.entity.BuildingEntity;
import com.dmuis.respository.BuildingRepository;
import com.dmuis.service.BuildingService;
@Service
public class BuildingServiceImple implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingResponseDTO> findAll(String name, Long districtId) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, districtId);
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for(BuildingEntity it : buildingEntities) {
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			buildingResponseDTO.setId(it.getId());
			buildingResponseDTO.setName(it.getName());
			buildingResponseDTO.setAddress(it.getStreet()+','+it.getWard()+','+it.getDistrictId());
			buildingResponseDTO.setNumberOfBasement(it.getNumberOfBasement());
			results.add(buildingResponseDTO);
		}
		return results;
	}
	
}
