package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.SbEntity;
import com.glx.oa.repository.SbRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/equ")
public class EquController {

    private  SbRepository sbRepository;
    @Autowired
    public EquController(SbRepository sbRepository){
        this.sbRepository = sbRepository;
    }

    @RequestMapping(value = "/equList")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONArray eqList(@RequestBody JSONObject req){
        JSONObject res = new JSONObject();
        List<SbEntity> list = this.sbRepository.findSbEntityByApplyType(req.getString("applyType"));
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }
    @RequestMapping(value = "/equSave")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject equSave(@RequestBody SbEntity sb){
        JSONObject res = new JSONObject();
        try{
            this.sbRepository.save(sb);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }

    @RequestMapping(value = "/equBatchRemove")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject equBatchRemove(@RequestBody List<SbEntity> sbList){
        JSONObject res = new JSONObject();
        try{
            this.sbRepository.deleteInBatch(sbList);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }
}
