package com.javaweb.repository;

import com.javaweb.entity.UserEntity;
import com.javaweb.repository.custom.UserRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> , UserRepositoryCustom {
    UserEntity findOneByUserNameAndStatus(String name, Long status);
    Page<UserEntity> findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(String userName, String fullName, Long status,
                                                                                                  Pageable pageable);
    List<UserEntity> findByStatusAndRoles_Code(Long status, String roleCode);
    Page<UserEntity> findByStatusNot(Long status, Pageable pageable);
    long countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(String userName, String fullName, Long status);
    long countByStatusNot(Long status);
    UserEntity findOneByUserName(String userName);
    List<UserEntity> findByIdIn(List<Long> id);
    boolean existsByUserName(String userName);
}
