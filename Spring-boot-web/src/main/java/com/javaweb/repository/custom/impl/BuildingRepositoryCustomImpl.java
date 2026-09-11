package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.utils.DataUtil;
import org.springframework.data.domain.Pageable;
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
    private EntityManager entityManager;

    private static String sqlCountTotalItem;
    private void sqlJOIN(StringBuilder sql, BuildingSearchBuilder builder){
        Long staffId = builder.getStaffId();
        if(DataUtil.checkData(staffId)){
            sql.append("JOIN assignmentbuilding ab ON b.id = ab.buildingid ");
        }
        Long rentAreaFrom = builder.getRentAreaFrom();
        Long rentAreaTo = builder.getRentAreaTo();
        if(DataUtil.checkData(rentAreaFrom) || DataUtil.checkData(rentAreaTo) ){
            sql.append("JOIN rentarea re ON b.id = re.buildingid ");
        }
    }
    private void sqlWhere(StringBuilder sql, BuildingSearchBuilder builder){
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if(!fieldName.equals("staffId")
                        && !fieldName.startsWith("rentPrice")
                        && !fieldName.startsWith("rentArea")
                        && !fieldName.equals("typeCode")){
                    Object object = field.get(builder);
                    if(DataUtil.checkData(object)){
                        if(field.getType().getName().equals("java.lang.Long")){
                            sql.append(" AND b." + fieldName + " = " + object);
                        }
                        if(field.getType().getName().equals("java.lang.String")){
                            sql.append(" AND b." + fieldName + " LIKE '%" + object + "%'");
                        }
                        if(field.getType().getName().equals("java.lang.Integer")){
                            sql.append(" AND b." + fieldName + " = " + object);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void sqlWhereSpecial(StringBuilder sql, BuildingSearchBuilder builder){
        Long staffId = builder.getStaffId();
        if(DataUtil.checkData(staffId)){
            sql.append(" AND ab.staffId = " + staffId);
        }
        Long rentAreaFrom = builder.getRentAreaFrom();
        if(DataUtil.checkData(rentAreaFrom)){
            sql.append(" AND re.value >= " + rentAreaFrom);
        }
        Long rentAreaTo = builder.getRentAreaTo();
        if(DataUtil.checkData(rentAreaTo)){
            sql.append(" AND re.value <= " + rentAreaTo);
        }
        Long rentPriceFrom = builder.getRentPriceFrom();
        if(DataUtil.checkData(rentPriceFrom)){
            sql.append(" AND b.rentprice >= " + rentPriceFrom);
        }
        Long rentPriceTo = builder.getRentPriceTo();
        if(DataUtil.checkData(rentPriceTo)){
            sql.append(" AND b.rentprice <= " + rentPriceTo);
        }
        List<String> typeCode = builder.getTypeCode();
        if(typeCode != null && typeCode.size() > 0){
            sql.append(" AND b.type IN (" + typeCode.stream().map(i -> "'" + i +"'").collect(Collectors.joining(",")) +")");
        }
    }

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT b.* FROM building b ");
        sqlJOIN(sql, builder);
        StringBuilder sqlWHERE = new StringBuilder(" WHERE 1 = 1");
        sqlWhere(sqlWHERE, builder);
        sqlWhereSpecial(sqlWHERE, builder);
        sql.append(sqlWHERE);
        sqlCountTotalItem = sql.toString();

        //Them limit va offset de phan trang
        sql.append(" LIMIT :limit OFFSET :offset ");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);

        //Gan gia tri cho limit va offset
        query.setParameter("limit", pageable.getPageSize());
        query.setParameter("offset", pageable.getOffset());

        return query.getResultList();
    }

    @Override
    public int countTotalItem() {
        String sql = sqlCountTotalItem;
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList().size();
    }
}
