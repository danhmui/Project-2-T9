package com.dmuis.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.DistrictRepository;
import com.dmuis.repository.RentAreaRepository;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.repository.entity.DistrictEntity;
import com.dmuis.repository.entity.RentAreaEntity;

@Component // dinh nghia 1 bean trong spring boot
public class BuildingConverter {
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private ModelMapper modelMapper;
	public BuildingResponseDTO toBuildingResponseDTO(BuildingEntity it) {
		BuildingResponseDTO buildingResponseDTO = modelMapper.map(it, BuildingResponseDTO.class);
		DistrictEntity districtEntity = districtRepository.findById(it.getDistrictId());
		buildingResponseDTO.setAddress(it.getStreet() + ", " + it.getWard() +", "+ districtEntity.getName());
		List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuildingId(it.getId());
		String rentArea = rentAreaEntities.stream().map(i -> i.getValue().toString()).collect(Collectors.joining(","));
		buildingResponseDTO.setRentArea(rentArea);
		return buildingResponseDTO;
	}
}
