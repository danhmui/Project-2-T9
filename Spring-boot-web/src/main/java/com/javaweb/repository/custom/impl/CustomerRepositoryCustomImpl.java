package com.javaweb.repository.custom.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import com.javaweb.utils.DataUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    private String sqlCountTotalItem;
    public void sqlJoin(StringBuilder sql, CustomerSearchBuilder builder){
        if(DataUtil.checkData(builder.getStaffId()))
            sql.append(" JOIN assignmentcustomer ac ON ac.customerid = c.id");
    }

    public void sqlWhere(StringBuilder sql, CustomerSearchBuilder builder){
        try {
            Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(builder);
                if(fieldValue != null && fieldValue != "") {
                    if(!fieldName.equals("staffId")) {
                        if (field.getType().getName().equals("java.lang.Long"))
                            sql.append(" AND c." + fieldName + " = " + fieldValue);
                        if (field.getType().getName().equals("java.lang.String"))
                            sql.append(" AND c." + fieldName + " LIKE '%" + fieldValue + "%'");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sqlWhereSpecial(StringBuilder sql, CustomerSearchBuilder builder){
        if (DataUtil.checkData(builder.getStaffId())) {
            sql.append(" AND ac.staffid = " + builder.getStaffId());
        }
    }
    @Override
    public List<CustomerEntity> findAll(CustomerSearchBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT c.* FROM customer c");
        sqlJoin(sql, builder);
        StringBuilder sqlWhere = new StringBuilder(" WHERE 1 = 1");
        sqlWhere(sqlWhere, builder);
        sqlWhereSpecial(sql, builder);
        sql.append(sqlWhere);
        sql.append(" AND c.is_active = 1");
        sqlCountTotalItem = sql.toString();
        sql.append(" ORDER BY c.createddate DESC");
        sql.append(" LIMIT :limit OFFSET :offset ");
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        query.setParameter("limit", pageable.getPageSize());
        query.setParameter("offset", pageable.getOffset());
        return query.getResultList();
    }

    @Override
    public int countTotalItem() {
        String sql = sqlCountTotalItem;
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList().size();
    }
}
