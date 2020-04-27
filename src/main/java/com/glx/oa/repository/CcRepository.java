package com.glx.oa.repository;

import com.glx.oa.entity.CcEntity;
import com.glx.oa.entity.SbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CcRepository extends JpaRepository<CcEntity,Integer> {
    List<CcEntity> findCcEntityByApplyName(String applyName);

}
