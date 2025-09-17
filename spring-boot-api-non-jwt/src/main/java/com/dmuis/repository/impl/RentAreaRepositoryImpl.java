package com.dmuis.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmuis.repository.RentAreaRepository;
@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
	private String DB_URL = BuildingRepositoryImpl.DB_URL;
	private String USER = BuildingRepositoryImpl.USER;
	private String PASS = BuildingRepositoryImpl.PASS;
	
	public List<Long> findAll(Long buildingId) {
		String sql = "SELECT value FROM RentArea WHERE buildingid = " + buildingId;
		List<Long> results = new ArrayList<Long>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stm = conn.createStatement();
				   ResultSet rs = stm.executeQuery(sql)){
			   while(rs.next()) {
				   results.add(rs.getLong("value"));
			   }
		      } catch (SQLException e) {
		         e.printStackTrace();
		          System.out.println("Connected database failed...");
		      } 
		return results;
	}
	
}
