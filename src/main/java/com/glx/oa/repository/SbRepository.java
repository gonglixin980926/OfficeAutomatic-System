package com.glx.oa.repository;

import com.glx.oa.entity.SbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SbRepository extends JpaRepository<SbEntity,Integer> {
    List<SbEntity> findSbEntityByApplyName(String applyName);

    List<SbEntity> findSbEntityByApplyType(String applyType);
}
