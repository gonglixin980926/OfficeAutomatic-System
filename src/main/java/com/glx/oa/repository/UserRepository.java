package com.glx.oa.repository;

import com.glx.oa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserEntityByUserId(int id);
    UserEntity findUserEntityByUserName(String userName);

    List<UserEntity> findAll();

    List<UserEntity> findUserEntityByPermission(Integer permission);

    Integer deleteUserEntityByUserId(int id);

    UserEntity save(UserEntity userEntity);

//    void deleteAllInBatch();
}
