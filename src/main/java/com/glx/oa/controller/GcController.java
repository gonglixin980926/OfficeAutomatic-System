package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.GcEntity;
import com.glx.oa.entity.SbEntity;
import com.glx.oa.repository.GcRepository;
import com.glx.oa.repository.SbRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/gc")
public class GcController {

    private GcRepository gcRepository;
    @Autowired
    public GcController(GcRepository gcRepository){
        this.gcRepository = gcRepository;
    }

    @RequestMapping(value = "/gcList")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONArray eqList(@RequestBody JSONObject req){
//        JSONObject res = new JSONObject();
        List<GcEntity> list = this.gcRepository.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/gcSave")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject gcSave(@RequestBody GcEntity gc){
        JSONObject res = new JSONObject();
        try{
            this.gcRepository.save(gc);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }

    @RequestMapping(value = "/gcBatchRemove")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject gcBatchRemove(@RequestBody List<GcEntity> List){
        JSONObject res = new JSONObject();
        try{
            this.gcRepository.deleteInBatch(List);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }
}
