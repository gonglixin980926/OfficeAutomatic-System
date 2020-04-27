package com.glx.oa.repository;

import com.glx.oa.entity.GcEntity;
import com.glx.oa.entity.SbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GcRepository extends JpaRepository<GcEntity,Integer> {
    List<GcEntity> findGcEntityByApplyName(String applyName);

}
