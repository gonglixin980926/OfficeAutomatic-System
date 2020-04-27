package com.glx.oa.repository;

import com.glx.oa.entity.XmjdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XmjdRepository extends JpaRepository<XmjdEntity,Integer> {
    List<XmjdEntity> findAll();
}
