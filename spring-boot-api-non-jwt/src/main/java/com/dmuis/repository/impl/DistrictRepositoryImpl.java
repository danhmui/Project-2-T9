package com.dmuis.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.dmuis.repository.DistrictRepository;
import com.dmuis.repository.entity.DistrictEntity;
import com.dmuis.utils.ConnectionUtil;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
	
	@Override
	public DistrictEntity findById(Long id) {
		String sql = "SELECT d.* FROM district d WHERE d.id = " +  id;
		DistrictEntity districtEntity = new DistrictEntity();
		try(Connection conn = ConnectionUtil.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString());) {
				while(rs.next()) {
					districtEntity.setId(rs.getLong("id"));
					districtEntity.setCode(rs.getString("code"));
					districtEntity.setName(rs.getString("name"));
				}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Connected to database failed...");
		}
		return districtEntity;
	}
	
}
