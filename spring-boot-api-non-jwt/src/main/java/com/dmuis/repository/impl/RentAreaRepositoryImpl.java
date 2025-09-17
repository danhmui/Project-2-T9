package com.dmuis.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	@Override
	public List<Long> findValue(Long buildingId) {
		StringBuilder sql = new StringBuilder("SELECT value FROM rentarea");
		sql.append(" WHERE 1=1 AND buildingId = ");
		sql.append(buildingId);
		List<Long> value = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString())) {
			while(rs.next()) {
				value.add(rs.getLong("value"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connected to databased failed...");
		}
		return value;
	}
	
}