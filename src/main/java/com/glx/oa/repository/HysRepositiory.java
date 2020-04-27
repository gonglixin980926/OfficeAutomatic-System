package com.glx.oa.repository;

import com.glx.oa.entity.HysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HysRepositiory extends JpaRepository<HysEntity,Integer> {
    List<HysEntity> findAll();
}
