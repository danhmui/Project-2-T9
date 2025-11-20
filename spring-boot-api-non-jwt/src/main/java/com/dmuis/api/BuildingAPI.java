package com.dmuis.api;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmuis.customexceptions.InvalidDataException;
import com.dmuis.dto.BuildingDTO;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.repository.entity.DistrictEntity;
import com.dmuis.service.BuildingService;


@RestController

public class BuildingAPI {
	@Autowired BuildingService buildingService;
	@GetMapping("/api/building")
	private List<BuildingResponseDTO> findAll(@RequestParam(required = false) List<String> typeCode,
											@RequestParam(required = false) Map<String, Object> requestParams){
		List<BuildingResponseDTO> results = buildingService.findAll(typeCode, requestParams);
		return results;
	};
	private void validate(BuildingDTO buildings) {
	if (buildings.getName() == null || buildings.getName().equals("")|| buildings.getNumberOfBasement() == null)
		throw new InvalidDataException("Name or NumberOfBasement mustn't null!!!");
}
	@PostMapping("/api/building")
	private Object createBuildings(@RequestBody BuildingDTO building) {
		validate(building);
		return buildingService.createBuilding(building);
	}
	@PutMapping("/api/buildings")
	private Object updateBuildings(@RequestBody BuildingDTO buildings) {
		if(buildings.getId() != null) {
			buildingService.updateBuilding(buildings);
		}
		else {
			//tra ve chi tiet loi
		}
		return null;
	}
//
//@DeleteMapping("/api/building")
//private void deleteBuildings(@PathVariable Long[] ids) {
//	System.out.println(ids);
//}
	
}