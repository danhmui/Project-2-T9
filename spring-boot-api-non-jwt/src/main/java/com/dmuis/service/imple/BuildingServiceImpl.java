package com.dmuis.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.RentAreaRepository;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Override
	public List<BuildingResponseDTO> findAll(List<String> typeCode, Map<String, Object> requestParams) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(typeCode, requestParams);
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for(BuildingEntity it : buildingEntities ) {
			//Lay repo cua bang rentarea
			List<Long> value = rentAreaRepository.findValue(it.getId());
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			buildingResponseDTO.setId(it.getId());
			buildingResponseDTO.setNameBuilding(it.getName());
			buildingResponseDTO.setAddress(it.getStreet() + ", " + it.getWard() +", Quận "+ it.getDistrictId());
			buildingResponseDTO.setNumberOfBasement(it.getNumberOfBasement());
			buildingResponseDTO.setManagerName(it.getManagerName());
			buildingResponseDTO.setManagerPhoneNumber(it.getManagerPhoneNumber());
			buildingResponseDTO.setFloorArea(it.getFloorArea());
			buildingResponseDTO.setEmptyArea(null);
			buildingResponseDTO.setRentArea(value);
			buildingResponseDTO.setRentPrice(it.getRentPrice());
			buildingResponseDTO.setServiceFee(null);
			buildingResponseDTO.setBrokerFee(null);
			results.add(buildingResponseDTO);
		}
		return results;
	}
	
}