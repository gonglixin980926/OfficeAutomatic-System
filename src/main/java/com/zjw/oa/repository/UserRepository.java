package com.zjw.oa.repository;

import com.zjw.oa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserEntityByUserId(int id);
}
