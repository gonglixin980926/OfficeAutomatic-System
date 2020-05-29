package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.GcEntity;
import com.glx.oa.entity.QjsqEntity;
import com.glx.oa.entity.RwEntity;
import com.glx.oa.entity.RzEntity;
import com.glx.oa.repository.RwRepository;
import com.glx.oa.repository.RzRepositiory;
import com.glx.oa.repository.UserRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @author dddz97
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/rwxx")
public class RwController {

    private RwRepository rwRepository;
    private RzRepositiory rzRepositiory;
    private UserRepository userRepository;

    @Autowired
    public RwController(RwRepository rwRepository, RzRepositiory rzRepositiory, UserRepository userRepository) {
        this.rzRepositiory = rzRepositiory;
        this.rwRepository = rwRepository;
        this.userRepository = userRepository;
    }


    /**
     * 查看自己的工作任务 - 列表
     *
     * @param rw
     * @return
     */
    @RequestMapping(value = "/myRw")
    @ResponseBody
    @CrossOrigin
    public JSONArray myRw(@RequestBody JSONObject rw) {
        List<RwEntity> list = this.rwRepository.findRwEntityByJsUserName(rw.getString("jsUserName"));
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/allRw")
    @ResponseBody
    @CrossOrigin
    public JSONArray allRw(@RequestBody JSONObject req) {
        List<RwEntity> list = this.rwRepository.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/delRw")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject delRw(@RequestBody JSONObject req) {
        JSONObject res = new JSONObject();
//        Integer id = Integer.parseInt((String) req.get("id"));
//        Integer a = this.rwRepository.deleteRwEntityByRwId(req.getInteger("id"));
        try {
            Integer a = this.rwRepository.deleteRwEntityByRwId(req.getInteger("id"));
            res.put("message", "success");
        } catch (Exception ignored) {
            res.put("message", "server error");
        }
        return res;
    }

//    @RequestMapping(value = "/batchRemoveRw")
//    @ResponseBody
//    @CrossOrigin
//    @Transactional
//    public JSONObject batchRemoveRw(@RequestBody JSONObject req) {
//        JSONArray ids = req.getJSONArray("ids");
//        JSONObject res = new JSONObject();
//        try {
//            this.rwRepository.deleteRwEntityByRwIdIn(ids);
//            res.put("message", "success");
//        } catch (Exception ignored) {
//            res.put("message", "server error");
//        }
//        return new JSONObject();
//    }

    @RequestMapping(value = "/addRw")
    @ResponseBody
    @CrossOrigin
    public JSONObject addRw(@RequestBody RwEntity rw) {
        RwEntity rw1 = null;
        JSONObject res = new JSONObject();
        try {
            rw1 = this.rwRepository.save(rw);
        } catch (Exception e) {

        }
        if (rw1 == null) {
            res.put("msg", "serverError");
        } else {
            res.put("msg", "sucess");
        }
        return res;
    }

//
//    /**
//     * 查看自己的工作任务 - 详情
//     * @param rw
//     * @return
//     */
//    @RequestMapping(value = "/rwXq")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject rwXq(Rw rw) {
//        Rw rw1 = rwService.rwXq(rw);
//        String jsonStr = JsonUtil.serialize(rw1);
//        return JSON.parseObject(jsonStr);
//    }

//    /**
//     * 删除任务 - 权限
//     * @param rw
//     * @return
//     */
//    @RequestMapping(value = "/delRw")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject delRw(Rw rw) {
//        try{
//            rwService.delRw(rw);
//        }catch (Exception e){
//            return JSON.parseObject("{success:false,msg:\"删除任务失败！\"}");
//        }
//        return JSON.parseObject("{success:true,msg:\"删除任务成功！\"}");
//    }

//    /**
//     * 修改任务 - 权限
//     * @param rw
//     * @return
//     */
//    @RequestMapping(value = "/updateRw")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject updateRw(Rw rw) {
//        try{
//            rwService.updateRw(rw);
//        }catch (Exception e){
//            return JSON.parseObject("{success:false,msg:\"编辑任务失败！\"}");
//        }
//        return JSON.parseObject("{success:true,msg:\"编辑任务成功！\"}");
//    }

    //    /**
//     * 添加任务 - 权限
//     * @param rw
//     * @return
//     */
//    @RequestMapping(value = "/addRw")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject addRw(Rw rw) {
//        try{
//            rwService.addRw(rw);
//        }catch (Exception e){
//            return JSON.parseObject("{success:false,msg:\"添加任务失败！\"}");
//        }
//        return JSON.parseObject("{success:true,msg:\"添加任务成功！\"}");
//    }
    @RequestMapping(value = "/rzList")
    @CrossOrigin
    public JSONArray getQjList() {
        List<RzEntity> list = this.rzRepositiory.findAll();
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/addRz")
    @ResponseBody
    @CrossOrigin
    public JSONObject addRz(@RequestBody RzEntity rz) {
        RzEntity rz1 = null;
        JSONObject res = new JSONObject();
        try {
            rz1 = this.rzRepositiory.save(rz);
        } catch (Exception e) {

        }
        if (rz1 == null) {
            res.put("msg", "serverError");
        } else {
            res.put("msg", "sucess");
        }
        return res;
    }

    @RequestMapping(value = "/saveRw")
    @ResponseBody
    @CrossOrigin
    public JSONObject saveRw(@RequestBody RwEntity rw) {
        JSONObject res = new JSONObject();
        try {
            res.put("msg", "sucess");
            this.rwRepository.save(rw);
        } catch (Exception e) {
            res.put("msg", "serverError");
        }
        return res;
    }

    @RequestMapping(value = "/batchRemoveRw")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject batchRemoveRw(@RequestBody List<RwEntity> List) {
        JSONObject res = new JSONObject();
        try {
            this.rwRepository.deleteInBatch(List);
            res.put("msg", "保存成功");
        } catch (Exception e) {
            res.put("msg", "保存失败");
        }
        return res;
    }
//    /**
//     * 查看日志 - 列表
//     * @return
//     */
//    @RequestMapping(value = "/rzList")
//    @ResponseBody
//    @CrossOrigin
//    public JSONArray rzList(String rzTime) {
//
//        List<Rz> list = rwService.rzList(rzTime);
//        String jsonStr = JsonUtil.serializeDate(list);
//        return JSON.parseArray(jsonStr);
//    }

//    /**
//     * 添加日志
//     * @param rz
//     * @return
//     */
//    @RequestMapping(value = "/addRz")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject addRz(Rz rz) {
//        try{
//            rwService.addRz(rz);
//        }catch (Exception e){
//            return JSON.parseObject("{success:false,msg:\"添加日志失败！\"}");
//        }
//        return JSON.parseObject("{success:true,msg:\"添加日志成功！\"}");
//    }

    public static void main(String[] args) throws ParseException {
        String string = "2016-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(string);
        System.out.println(date.getTime());
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        System.out.println(date2);
    }
}
