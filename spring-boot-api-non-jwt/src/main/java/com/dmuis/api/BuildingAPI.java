package com.dmuis.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmuis.dto.response.BuildingResponseDTO;
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
//	private void validate(BuildingDTO buildings) {
//	if (buildings.getDistrictId() == null ||  buildings.getStaffId() == null || buildings.get)
//		throw new InvalidDataException("Name or NumberOfBasement mustn't null!!!");
//}
//
//@PostMapping("/api/building")
//private Object createBuildings(@RequestBody BuildingDTO buildings) {
//	validate(buildings);
//	return buildings;
//}
//
//@DeleteMapping("/api/building")
//private void deleteBuildings(@PathVariable Long[] ids) {
//	System.out.println(ids);
//}
	
}