package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.XmjdEntity;
import com.glx.oa.entity.GsggEntity;
import com.glx.oa.repository.GgRepository;
import com.glx.oa.repository.XmjdRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/gsxx")
public class GgController {

    private GgRepository ggRepository;
    private XmjdRepository xmjdRepository;
    @Autowired
    public GgController(GgRepository ggRepository, XmjdRepository xmjdRepository){
        this.ggRepository = ggRepository;
        this.xmjdRepository = xmjdRepository;
    }

//    @Resource

    /**
     * 公告
     * @return
     */
    @RequestMapping(value = "/gsgg")
    @ResponseBody
    @CrossOrigin
    public JSONArray getGgList() {

        List<GsggEntity> list = this.ggRepository.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    /**
     * 项目进度
     * @return
     */
    @RequestMapping(value = "/xmjd")
    @ResponseBody
    @CrossOrigin
    public JSONArray getXmList() {
        List<XmjdEntity> list = this.xmjdRepository.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    /**
     * 删除公告
     * @return
     * */
    @RequestMapping(value = "/delGg")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject delGg(@RequestBody JSONObject param){
        JSONObject res = new JSONObject();
        JSONObject data = new JSONObject();
        Integer user = this.ggRepository.deleteGsggEntityByGgId((Integer) param.get("ggId"));
        if(user!=null){
            data.put("msg","删除成功");
            res.put("data",data);
            return res;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/addGg")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject addGg(@RequestBody GsggEntity gsggEntity){
        JSONObject res = new JSONObject();
        try{
            this.ggRepository.save(gsggEntity);
            res.put("msg","添加成功");

        }catch (Exception e){
            res.put("msg","添加失败");
        }
     return res;
    }
}
