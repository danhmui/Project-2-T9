package com.javaweb.api.admin;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@RestController("/api")
public class BuildingAPI {

    @Autowired
    IBuildingService buildingService;

    @GetMapping("/building-list")
    private List<BuildingResponseDTO> findAll(@RequestParam(required = false) Map<String, Object> params,
                                              @RequestParam(required = false) List<String> typeCode){
      List<BuildingResponseDTO> results = buildingService.findAll(params, typeCode);
      return results;
    }

//    @PostMapping("/api/buildings")
//    public ResponseEntity<?> createBuilding(@Valid @RequestBody BuildingDTO buildingDTO, BindingResult bindingResult){
//        try {
//            if(bindingResult.hasErrors()){
//                List<String> errors = bindingResult.getFieldErrors()
//                        .stream()
//                        .map(FieldError::getDefaultMessage)
//                        .collect(Collectors.toList());
//                return ResponseEntity.badRequest().body(errors);
//            }
//            BuildingResponseDTO buildingResponseDTO = buildingService.createBuilding(buildingDTO);
//            return ResponseEntity.ok(buildingResponseDTO);
//        }
//        catch (Exception ex){
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
    }
//}
