package com.glx.oa.repository;

import com.alibaba.fastjson.JSONArray;
import com.glx.oa.entity.RwEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RwRepository extends JpaRepository<RwEntity,Integer>{
        List<RwEntity> findRwEntityByJsUserName(String JsUserName);

        Integer deleteRwEntityByRwId(Integer id);

        RwEntity saveAndFlush(RwEntity rwEntity);

        void deleteRwEntityByRwIdIn(JSONArray ids);

        //        List<RwEntity> RwEntityAdd();
}
