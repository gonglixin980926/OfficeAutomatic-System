package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.CcEntity;
import com.glx.oa.entity.SbEntity;
import com.glx.oa.repository.CcRepository;
import com.glx.oa.repository.SbRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/cc")
public class CcController {

    private CcRepository ccRepository;
    @Autowired
    public CcController(CcRepository ccRepository){
        this.ccRepository = ccRepository;
    }

    @RequestMapping(value = "/ccList")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONArray eqList(@RequestBody JSONObject req){
        JSONObject res = new JSONObject();
//        List<CcEntity> list = this.ccRepository.findCcEntityByApplyName(req.getString("applyName"));
        List<CcEntity> list = this.ccRepository.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/ccSave")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject equSave(@RequestBody CcEntity cc){
        JSONObject res = new JSONObject();
        try{
            this.ccRepository.save(cc);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }

    @RequestMapping(value = "/ccBatchRemove")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject ccBatchRemove(@RequestBody List<CcEntity> List){
        JSONObject res = new JSONObject();
        try{
            this.ccRepository.deleteInBatch(List);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }
}
