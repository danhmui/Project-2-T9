package com.dmuis.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.dmuis.builder.BuildingSearchBuilder;
import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.entity.BuildingEntity;
import com.dmuis.utils.ConnectionUtil;
import com.dmuis.utils.DataUtil;
import com.dmuis.utils.NumberUtil;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	private void sqlJoin(BuildingSearchBuilder builder, StringBuilder join) {
		Long staffId = builder.getStaffId();
		if(DataUtil.checkData(staffId)) {
			join.append("JOIN assignmentbuilding a ON a.buildingid = b.id ");
		}
		Long rentAreaFrom = builder.getAreaFrom();
		Long rentAreaTo = builder.getAreaTo();
		if(DataUtil.checkData(rentAreaTo) || DataUtil.checkData(rentAreaFrom)) {
			join.append(" JOIN rentarea rt ON b.id = rt.buildingid");
		}
		List<String> typeCode = builder.getTypeCode();
		if(DataUtil.checkData(typeCode)) {
			join.append(" JOIN buildingrenttype bt ON b.id = bt.buildingid");
			join.append(" JOIN renttype ON renttype.id = bt.renttypeid");
		}
		
	}
	private void sqlWhere(BuildingSearchBuilder builder, StringBuilder where) {
//		for(Map.Entry<String, Object> it : requestParams.entrySet()) {
//			String key = it.getKey();
//			if(!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea") && !key.startsWith("rentPrice")) {
//				String value = it.getValue().toString();
//				if(!NumberUtil.checkNumber(value)) 
//					where.append(" AND b." + key + " LIKE '%" + value + "%'");
//				else 
//					where.append(" AND b." + key + " = " + value);
//				
//			}
//		}
		try {
		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		for(Field it : fields) {
			it.setAccessible(true);
			String fieldName = it.getName();
			if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("rentArea") && !fieldName.startsWith("rentPrice")) {
				Object value = it.get(builder);
				if(value != null) {
					if(it.getType().getName().equals("java.lang.String")) {
						where.append(" AND b." + fieldName + " LIKE '%" + value + "%'");
					}
					else if(it.getType().getName().equals("java.lang.Long") || it.getType().equals("java.lang.Integer")) {
						where.append(" AND b." + fieldName + " = " + value);
					}
				}
			}
		}
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private void sqlWhereSpecial(BuildingSearchBuilder builder,StringBuilder where) {
		Long staffId = builder.getStaffId();
		if(DataUtil.checkData(staffId)) {
			where.append(" AND a.staffid = " + staffId);
		}
		Long rentAreaFrom = builder.getRentPriceFrom();
		Long rentAreaTo = builder.getRentPriceTo();
		if(DataUtil.checkData(rentAreaFrom)) {
			where.append(" AND rt.value >= " + rentAreaFrom);
		}
		if(DataUtil.checkData(rentAreaTo)) {
			where.append(" AND rt.value <= " + rentAreaTo);
		}
		List<String> typeCode = builder.getTypeCode();
		if(typeCode != null && typeCode.size() != 0) {
			//Java 7
//			List<String> code = new ArrayList<String>();
//			for(String it : typeCode) {
//				code.add("'" + it + "'");
//			}
//			where.append(" AND renttype.code IN (" + String.join(",", code) + ")");
			where.append(" AND renttype.code IN (" + typeCode.stream().map(i -> "'" + i + "'").collect(Collectors.joining(",")) + ")");
		}
		
	}
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
		sqlJoin(builder, sql);
		sqlWhere(builder, sql);
		sqlWhereSpecial(builder, sql);
		sql.append(" GROUP BY b.id");
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		try(Connection conn = ConnectionUtil.getConnection();
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