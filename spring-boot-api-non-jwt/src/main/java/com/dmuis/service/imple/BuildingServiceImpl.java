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
import com.dmuis.repository.impl.RentAreaRepositoryImpl;
import com.dmuis.service.BuildingService;


@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Override
	public List<BuildingResponseDTO> findAll(List<String> typeCode,List<String> rentArea, Map<String, Object> requestBuilding) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(typeCode, rentArea, requestBuilding);
		List<BuildingResponseDTO> results = new ArrayList<BuildingResponseDTO>();
		for(BuildingEntity it : buildingEntities) {
			//Lay repo cua bang RentArea
			List<Long> rentAreas = rentAreaRepository.findAll(it.getId());
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			buildingResponseDTO.setId(it.getId());
			buildingResponseDTO.setName(it.getName());
			buildingResponseDTO.setAddress(it.getStreet() + ", " + it.getWard() + ", Quận " + it.getDistrictid()	);
			buildingResponseDTO.setNumberOfBasement(it.getNumberofbasement());
			buildingResponseDTO.setManagerName(it.getManagername());
			buildingResponseDTO.setManagerPhone(it.getManagerphonenumber());
			buildingResponseDTO.setFloorArea(it.getFloorarea());
			buildingResponseDTO.setEmptyArea(null);
			buildingResponseDTO.setRentPrice(it.getRentprice());
			buildingResponseDTO.setRentArea(rentAreas);
			buildingResponseDTO.setServiceFee(null);
			buildingResponseDTO.setBrokerageFee(null);
			results.add(buildingResponseDTO);
		}
		return results;
	}
	
}