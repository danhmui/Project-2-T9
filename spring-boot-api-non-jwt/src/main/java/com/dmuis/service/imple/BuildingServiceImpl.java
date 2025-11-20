package com.dmuis.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmuis.builder.BuildingSearchBuilder;
import com.dmuis.converter.BuildingConverter;
import com.dmuis.converter.BuildingSearchBuilderConverter;
import com.dmuis.dto.BuildingDTO;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.repository.entity.DistrictEntity;
import com.dmuis.service.BuildingService;
@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
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
	@Override
	public BuildingEntity createBuilding(BuildingDTO buildings) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildings.getName());
		buildingEntity.setStreet(buildings.getStreet());
		buildingEntity.setWard(buildings.getWard());
		buildingEntity.setNumberOfBasement(buildings.getNumberOfBasement());
		DistrictEntity districtEntity = entityManager.find(DistrictEntity.class, buildings.getDistrictId());
		buildingEntity.setDistrict(districtEntity);
		entityManager.persist(buildingEntity);
		return buildingEntity;	
	}
	@Override
	public BuildingEntity updateBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(buildingDTO.getId());
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setManagerName(buildingDTO.getManagerName());
		buildingEntity.setNumberOfBasement(buildingDTO.getNumberOfBasement());
		buildingEntity.setRentPrice(buildingDTO.getRentPrice());
		DistrictEntity districtEntity = entityManager.find(DistrictEntity.class, buildingDTO.getDistrictId());
		buildingEntity.setDistrict(districtEntity);
		entityManager.merge(buildingEntity);
		return buildingEntity;	
	}
	@Override
	public void deleteById(List<Long> ids) {
		for(Long id : ids) {
			BuildingEntity building = entityManager.find(BuildingEntity.class, id);
			entityManager.remove(building);
		}
		
	}
	
}