package com.glx.oa.repository;

import com.glx.oa.entity.GsggEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GgRepository extends JpaRepository<GsggEntity,Integer> {
    Integer deleteGsggEntityByGgId(Integer id);

    List<GsggEntity> findAll();

    GsggEntity save(GsggEntity gsggEntity);
}
