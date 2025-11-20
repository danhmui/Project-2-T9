package com.dmuis.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.dmuis.builder.BuildingSearchBuilder;
import com.dmuis.repository.BuildingRepository;
import com.dmuis.repository.entity.BuildingEntity;
@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
		//JPA
		//1. JPQL => .createQuery
		//2. SQL Native => .createNativeQuery
		String sql = "FROM BuildingEntity WHERE 1 = 1";
		Query query = entityManager.createQuery(sql, BuildingEntity.class);
		
		return query.getResultList();
	}
	
}
