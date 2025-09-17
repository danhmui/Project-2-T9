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
	public List<BuildingEntity> findAll(List<String> typeCode, Map<String, Object> requestParams) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
		if(requestParams.get("staffId") != null) 
			sql.append("JOIN assignmentbuilding a ON a.buildingid = b.id ");
		if(typeCode != null || !typeCode.isEmpty()) 
			sql.append("JOIN buildingrenttype br ON b.id = br.buildingid JOIN renttype r ON br.renttypeid = r.id ");
		sql.append(" WHERE 1=1 ");
		if(requestParams.get("districtId") != null) 
			sql.append("AND b.districtid = ").append(requestParams.get("districtId"));
		if(requestParams.get("staffId") != null) 
			sql.append(" AND a.staffId = ").append(requestParams.get("staffId"));
		if(requestParams.get("rentPriceFrom") != null && requestParams.get("rentPriceTo") != null) {
			sql.append(" AND b.rentprice >= ").append(requestParams.get("rentPriceFrom")).append(" AND b.rentprice <= ").append(requestParams.get("rentPriceTo"));
		}
		if(typeCode != null || !typeCode.isEmpty()) {
			sql.append(" AND r.code IN ('");
			for(int i = 0; i < typeCode.size(); i++) {
				if(i > 0)
					sql.append("','");
				sql.append(typeCode.get(i));
			}
			sql.append("')");
		}
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString())) {
				while(rs.next()) {
					BuildingEntity buildingEntity = new BuildingEntity();
					buildingEntity.setId(rs.getLong("id"));
					buildingEntity.setName(rs.getString("name"));
					buildingEntity.setStreet(rs.getString("street"));
					buildingEntity.setWard(rs.getString("ward"));
					buildingEntity.setDistrictId(rs.getLong("districtid"));
					buildingEntity.setNumberOfBasement(rs.getLong("numberofbasement"));
					buildingEntity.setFloorArea(rs.getLong("floorarea"));
					buildingEntity.setRentPrice(rs.getLong("rentprice"));
					buildingEntity.setManagerName(rs.getString("managername"));
					buildingEntity.setManagerPhoneNumber(rs.getString("managerphonenumber"));
					results.add(buildingEntity);
				}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Connected to database failed...");
		}
		return results;
	}
	
}