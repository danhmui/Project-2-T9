package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.utils.DataUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    private void sqlJoin(BuildingSearchBuilder builder, StringBuilder sql){
        Long staffId = builder.getStaffId();
        if(DataUtils.checkData(staffId)){
            sql.append(" JOIN assignmentbuilding a ON a.buildingid = b.id");
        }

        List<String> typeCode = builder.getTypeCode();
        if(DataUtils.checkData(typeCode)){
            sql.append(" JOIN buildingrenttype bt ON bt.buildingid = b.id");
            sql.append(" JOIN renttype r ON r.id = bt.renttypeid");
        }

        Long rentAreaFrom = builder.getAreaFrom();
        Long rentAreaTo = builder.getAreaTo();
        if(DataUtils.checkData(rentAreaFrom) || DataUtils.checkData(rentAreaTo)){
            sql.append(" JOIN rentarea ra ON r.buildingid = b.id");
        }
    }

    private void sqlWhere(BuildingSearchBuilder builder, StringBuilder sql){
        try{
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                String fieldName = field.getName();
                if(!fieldName.equals("staffId") && !fieldName.equals("typeCode")
                    && !fieldName.startsWith("rentPrice") && !fieldName.startsWith("rentArea")){
                    Object fieldValue = field.get(builder);
                    if(fieldValue != null){
                        if(field.getType().getName().equals("java.lang.Long")){
                            sql.append(" AND b." + fieldName + " = " + fieldValue);
                        }
                        else if(field.getType().getName().equals("java.lang.String")){
                            sql.append(" AND b."+ fieldName + " LIKE '%" + fieldValue + "%'");
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void sqlWhereSpecial(BuildingSearchBuilder builder, StringBuilder sql){
        Long staffId = builder.getStaffId();
        if(DataUtils.checkData(staffId)){
            sql.append(" AND a.staffId = " + staffId);
        }
        Long rentPriceTo = builder.getRentPriceTo();
        Long rentPriceFrom = builder.getRentPriceFrom();
        if(DataUtils.checkData(rentPriceFrom)){
            sql.append(" AND b.rentPriceFrom => " +  rentPriceFrom);
        }
        if(DataUtils.checkData(rentPriceTo)){
            sql.append(" AND b.rentPriceTo <= " +  rentPriceTo);
        }
        List<String> typeCode = builder.getTypeCode();
        if(typeCode != null && typeCode.size() > 0){
            sql.append(" AND r.code IN (" + typeCode.stream().map(i -> "'"+ i + "'").collect(Collectors.joining(",")) + ")");
        }
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
        sqlJoin(builder, sql);
        sql.append(" WHERE 1=1");
        sqlWhere(builder, sql);
        sqlWhereSpecial(builder, sql);
        sql.append(" GROUP BY b.id ");

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
