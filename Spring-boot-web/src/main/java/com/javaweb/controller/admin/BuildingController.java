package com.javaweb.controller.admin;



import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.enums.DistrictType;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.impl.UserService;
import com.javaweb.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private UserService userService;
    @Autowired
    private IBuildingService buildingService;

    @GetMapping("/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchRequest params){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("staffs", userService.getStaffs(1, "STAFF"));
        mav.addObject("districts", DistrictType.getDistrict());
        mav.addObject("typeCode", TypeCode.getType());
        Map<String,Object> requestParams = MapUtils.convertToMap(params);
        List<BuildingResponseDTO> buildingList = buildingService.findAll(requestParams, params.getTypeCode());
        mav.addObject("buildingList", buildingList);
        return mav;
    }

    @GetMapping("/admin/building-edit")
    public ModelAndView addBuilding(@ModelAttribute("building") BuildingDTO buildingDTO){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("districts", DistrictType.getDistrict());
        mav.addObject("typeCode", TypeCode.getType());
        return mav;
    }

    @GetMapping("/admin/building-edit-{id}")
    public ModelAndView editBuilding(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        //find building by id => buildingentity => buidingDTO
        mav.addObject("districts", DistrictType.getDistrict());
        mav.addObject("typeCode", TypeCode.getType());
        mav.addObject("building", BuildingDTO.class);
        return mav;
    }
}


