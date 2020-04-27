package com.glx.oa.repository;

import com.glx.oa.entity.JbEntity;
import com.glx.oa.entity.SbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JbRepository extends JpaRepository<JbEntity,Integer> {
    List<JbEntity> findJbEntityByApplyName(String applyName);

}
