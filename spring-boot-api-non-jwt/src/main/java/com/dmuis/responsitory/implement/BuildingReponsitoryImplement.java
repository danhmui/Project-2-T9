package com.dmuis.responsitory.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmuis.responsitory.entity.BuildingEntity;
import com.dmuis.respository.BuildingRepository;
@Repository
public class BuildingReponsitoryImplement implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/sieuthi";
	static final String USER = "root";
	static final String PASS = "chandoi00";
	String sql = "SELECT* FROM khachhang1 WHERE 1 = 1";
	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
			List<BuildingEntity> results = new ArrayList<>();
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					   Statement stm = conn.createStatement();
					   ResultSet rs = stm.executeQuery(sql)){
				   while(rs.next()) {
					   BuildingEntity building = new BuildingEntity();
					   building.setId(rs.getLong("id"));
					   building.setName(rs.getString("name"));
					   building.setDistrictId(rs.getLong("districtid"));
					   building.setNumberOfBasement(rs.getLong("numberofbasement"));
					   building.setStreet(rs.getString("street"));
					   building.setWard(rs.getString("ward"));
					   results.add(building);
				   }
			      } catch (SQLException e) {
			         e.printStackTrace();
			          System.out.println("Connected database failed...");
			      } 

			return results;
	}

}
