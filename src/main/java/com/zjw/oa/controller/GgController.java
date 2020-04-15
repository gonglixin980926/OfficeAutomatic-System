//package com.zjw.oa.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.zjw.oa.service.GgService;
//import com.zjw.oa.util.JsonUtil;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@EnableAutoConfiguration
//@RequestMapping(value = "/gsxx")
//public class GgController {
//
//    @Resource
//    private GgService ggService;
//
//    /**
//     * 公告
//     * @return
//     */
//    @RequestMapping(value = "/gsgg")
//    @ResponseBody
//    @CrossOrigin
//    public JSONArray getGgList() {
//        List<Gsgg> list = ggService.getGgList();
//        String jsonStr = JsonUtil.serializeDate(list);
//        return JSON.parseArray(jsonStr);
//    }
//
//    /**
//     * 项目进度
//     * @return
//     */
//    @RequestMapping(value = "/xmjd")
//    @ResponseBody
//    @CrossOrigin
//    public JSONArray getXmList() {
//        List<Xmjd> list = ggService.getxmList();
//        String jsonStr = JsonUtil.serializeDate(list);
//        return JSON.parseArray(jsonStr);
//    }
//
//    /**
//     * 删除公告
//     * @return
//     * */
//    @RequestMapping(value = "/delGg")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject delGg(@RequestBody JSONObject param){
////        JSONObject res = new JSONObject();
////        JSONObject data = new JSONObject();
//////        Boolean flag = ggService.delGsGG((Integer)param.get("ggId"));
////        data.put("msg","s");
////        param.get("ggId");
////        res.put("data",data);
////        List<Gsgg> list = ggService.getGgList();
//        return null;
//    }
//
//}
