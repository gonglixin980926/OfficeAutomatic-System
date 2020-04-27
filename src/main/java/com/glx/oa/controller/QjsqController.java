package com.glx.oa.controller;
//
//
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.QjsqEntity;
import com.glx.oa.entity.UserEntity;
import com.glx.oa.repository.QjsqRepositiory;
import com.glx.oa.repository.UserRepository;
import com.glx.oa.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/qjsq")
public class QjsqController {
    @Resource
    private QjsqRepositiory qjsqRepositiory;
    private UserRepository userRepository;

    @Autowired
    public QjsqController(QjsqRepositiory qjsqRepositiory,UserRepository userRepository){
        this.qjsqRepositiory = qjsqRepositiory;
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/getQjList")
    @CrossOrigin
    public JSONArray getQjList(@RequestBody JSONObject req) {
        Integer userId = req.getInteger("userId");
        UserEntity user = this.userRepository.findUserEntityByUserId(userId);
        List<QjsqEntity> qjList = new ArrayList<>();
        List<UserEntity> userList = new ArrayList<>();

        qjList = this.qjsqRepositiory.findAll();

//        if (user.getPermission()==1){
//            userList = this.userRepository.findUserEntityByPermission(2);
//            userList.addAll(this.userRepository.findUserEntityByPermission(3));
//        }else if (user.getPermission() == 2){
//            userList = this.userRepository.findUserEntityByPermission(3);
//        }else{
//            qjList = this.qjsqRepositiory.findQjsqEntityByQjUserId(userId);
//        }
//        if (userList.size()!=0 && qjList.size()==0){
//            for (int i=0; i<userList.size(); i++){
//                qjList.addAll(this.qjsqRepositiory.findQjsqEntityByQjUserId(userList.get(i).getUserId()));
//            }
//        }
//         = this.userRepository.findUserEntityByPermission(3);
//        Integer per = this.qjsqRepositiory
        String jsonStr = JsonUtil.serializeDate(qjList);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/addQj")
    @ResponseBody
    @CrossOrigin
    public JSONObject addQj(@RequestBody QjsqEntity qjsqEntity) {
        QjsqEntity qj1 = null;
        JSONObject res = new JSONObject();
        try {
            qj1 = this.qjsqRepositiory.save(qjsqEntity);
        }catch (Exception e){

        }
        if (qj1 == null){
            res.put("msg","serverError");
        }else{
            res.put("msg","sucess");
        }
        return res;
    }



//    /**
//     * 请假详情
//     * @param qjsq
//     * @return
//     */
//    @RequestMapping(value = "/getQjXx")
//    @CrossOrigin
//    public JSONObject getQjXx(Qjsq qjsq) {
//        Qjsq qjsq1 = qjsqService.getQj(qjsq);
//        String jsonStr = JsonUtil.serialize(qjsq1);
//        return JSON.parseObject(jsonStr);
//    }
//
    /**
     * 批准下级员工的请假申请；（权限）
     * @param qjsqEntity
     * @return JSONObject
     */
    @RequestMapping(value = "/agreeQj")
    @CrossOrigin
    public JSONObject agreeQj(@RequestBody QjsqEntity qjsqEntity) {
        try{
            this.qjsqRepositiory.save(qjsqEntity);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"审批失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"审批成功！\"}");
    }

    @RequestMapping(value = "/qjBatchRemove")
    @ResponseBody
    @CrossOrigin
//    @Transactional
    public JSONObject qjBatchRemove(@RequestBody List<QjsqEntity> List){
        JSONObject res = new JSONObject();
        try{
            this.qjsqRepositiory.deleteInBatch(List);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }
//
}
