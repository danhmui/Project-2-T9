package com.dmuis.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmuis.repository.RentAreaRepository;
import com.dmuis.repository.entity.RentAreaEntity;
import com.dmuis.utils.ConnectionUtil;
@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
	
	@Override
	public List<RentAreaEntity> findByBuildingId(Long buildingId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM rentarea");
		sql.append(" WHERE 1=1 AND buildingId = ");
		sql.append(buildingId);
		List<RentAreaEntity> results = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString())) {
			while(rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setBuildingId(rs.getLong("buildingid"));
				rentAreaEntity.setId(rs.getLong("id"));
				rentAreaEntity.setValue(rs.getLong("value"));
				results.add(rentAreaEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connected to databased failed...");
		}
		return results;
	}
	
}