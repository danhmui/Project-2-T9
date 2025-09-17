package com.dmuis.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "chandoi00";
	@Override
	public List<BuildingEntity> findAll(List<String> typeCode, List<String> rentArea, Map<String, Object> requestBuilding) {
		String sql = "SELECT b.* FROM building b";
		if(requestBuilding.get("staffId") != null) {
			sql += " JOIN assignmentbuilding a ON a.buildingid = b.id ";
		}
		if(typeCode != null || !typeCode.isEmpty()) {
			sql += " JOIN buildingrenttype br ON b.id = br.buildingid JOIN renttype r ON br.renttypeid = r.id";
		}
		sql += " WHERE 1=1 ";
		if(requestBuilding.get("districtId") != null) {
			sql += " AND b.districtid = " + requestBuilding.get("districtId");
		}
		if(requestBuilding.get("staffId") != null) {
			sql += " AND a.staffId = " +requestBuilding.get("staffId");
		}
		if(requestBuilding.get("rentPriceFrom") != null && requestBuilding.get("rentPriceTo") != null) {
			sql += " AND b.rentprice BETWEEN " + requestBuilding.get("rentPriceFrom") + " AND " + requestBuilding.get("rentPriceTo");
		}
		if(typeCode != null || !typeCode.isEmpty()) {
			sql += " AND r.code IN ('";
			for(int i = 0; i < typeCode.size(); i++) {
				if(i > 0) 
					sql += "','";
				sql += typeCode.get(i);
			}
			sql += "')";
			
		}
		List<BuildingEntity> results = new ArrayList<>();	
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stm = conn.createStatement();
				   ResultSet rs = stm.executeQuery(sql)){
			   while(rs.next()) {
				   BuildingEntity building = new BuildingEntity();
				   building.setId(rs.getLong("id"));
				   building.setName(rs.getString("name"));
				   building.setStreet(rs.getString("street"));
				   building.setWard(rs.getString("ward"));
				   building.setDistrictid(rs.getLong("districtid"));
				   building.setNumberofbasement(rs.getLong("numberofbasement"));
				   building.setFloorarea(rs.getLong("floorarea"));
				   building.setManagername(rs.getString("managername"));
				   building.setManagerphonenumber(rs.getString("managerphonenumber"));
				   results.add(building);
			   }
		      } catch (SQLException e) {
		         e.printStackTrace();
		          System.out.println("Connected database failed...");
		      } 
		return results;
	}
	

}
