package com.dmuis.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.dmuis.customexceptions.InvalidDataException;
import com.dmuis.dto.BuildingDTO;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping("/api/building")
	private Object getBuildings(@RequestParam(required = false) List<String> typeCode,
							@RequestParam(required = false) List<String> rentArea,
							@RequestParam(required = false) Map<String, Object> requestBuilding) {
		List<BuildingResponseDTO> buildings = buildingService.findAll(typeCode, rentArea, requestBuilding);
		return buildings; 	
	}

//	private void validate(BuildingDTO buildings) {
//		if (buildings.get() == null || buildings.getName().equals("") || buildings.getNumberOfBasement() == null)
//			throw new InvalidDataException("Name or NumberOfBasement mustn't null!!!");
//	}
//
//	@PostMapping("/api/building")
//	private Object createBuildings(@RequestBody BuildingDTO buildings) {
//		validate(buildings);
//		return buildings;
//	}
//
//	@DeleteMapping("/api/building")
//	private void deleteBuildings(@PathVariable Long[] ids) {
//		System.out.println(ids);
//	}
}
