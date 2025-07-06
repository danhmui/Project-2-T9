package com.dmuis.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmuis.customexceptions.InvalidDataException;
import com.dmuis.dto.BuildingDTO;
import com.dmuis.dto.response.BuildingResponseDTO;
import com.dmuis.service.BuildingService;

@RestController
public class BuildingAPI{
	@Autowired
	private BuildingService buildingService;
	@GetMapping("/api/buildings")
	private Object getBuildings(@RequestParam (name = "name", required = false)String name,
							@RequestParam (name = "districtId", required = false)Long districtId) {
		List<BuildingResponseDTO> buildings = buildingService.findAll(name, districtId);
		return buildings;
		 
	}
	private void validate(BuildingDTO buildings) throws InvalidDataException {
		if((buildings.getName() == null || buildings.getName().equals(""))
				||buildings.getNumberOfBasement() == null) {
			throw new InvalidDataException("Name or BaseMent mustn't empty!");
		}
	}
	@PostMapping("/api/building")
	private Object createBuilding(@RequestBody BuildingDTO building){
		validate(building);
		return building;
	}

}
