package com.glx.oa.repository;

import com.glx.oa.entity.RzEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RzRepositiory extends JpaRepository<RzEntity,Integer> {
    List<RzEntity> findAll();
    RzEntity save(RzEntity rzEntity);
}
