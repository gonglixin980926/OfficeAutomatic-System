package com.glx.oa.repository;

import com.glx.oa.entity.QjsqEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QjsqRepositiory extends JpaRepository<QjsqEntity,Integer> {
    List<QjsqEntity> findAll();

    List<QjsqEntity> findQjsqEntityByQjUserId(Integer id);

    QjsqEntity saveAndFlush(QjsqEntity qjsqEntity);
//    QjsqEntity update(QjsqEntity qjsqEntity);
}
