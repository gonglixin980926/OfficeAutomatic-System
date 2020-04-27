package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.JbEntity;
import com.glx.oa.entity.SbEntity;
import com.glx.oa.repository.JbRepository;
import com.glx.oa.repository.SbRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/jb")
public class JbController {

    private JbRepository jbRepository;
    @Autowired
    public JbController(JbRepository jbRepository){
        this.jbRepository = jbRepository;
    }

    @RequestMapping(value = "/jbList")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONArray eqList(@RequestBody JSONObject req){
        JSONObject res = new JSONObject();
        List<JbEntity> list = this.jbRepository.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/jbSave")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject jbSave(@RequestBody JbEntity jb){
        JSONObject res = new JSONObject();
        try{
            this.jbRepository.save(jb);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }

    @RequestMapping(value = "/jbBatchRemove")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject equBatchRemove(@RequestBody List<JbEntity> List){
        JSONObject res = new JSONObject();
        try{
            this.jbRepository.deleteInBatch(List);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }
}
