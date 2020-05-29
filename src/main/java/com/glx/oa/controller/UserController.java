package com.glx.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.glx.oa.entity.HysEntity;
import com.glx.oa.entity.UserEntity;
import com.glx.oa.repository.HysRepositiory;
import com.glx.oa.repository.UserRepository;
import com.glx.oa.util.JsonUtil;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    private UserRepository userRepository;
    private HysRepositiory hysRepositiory;

    @Autowired
   public UserController(UserRepository userRepository,HysRepositiory hysRepositiory){
        this.hysRepositiory = hysRepositiory;
        this.userRepository = userRepository;
    }

    /**
     * Description 登录，可以加入@CrossOrigin支持跨域。
     *
     * @param user 用户输入的学号和密码
     * @return Result
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject login(@RequestBody UserEntity user) {
        UserEntity user1 =this.userRepository.findUserEntityByUserName(user.getUserName());
        JSONObject res = new JSONObject();
        if (user1.getPwd().equals(user.getPwd())){

            JSONObject userInfo = new JSONObject();
            userInfo.put("isAdmin","false");
            userInfo.put("userName",user1.getUserName());
            userInfo.put("zw",user1.getZw());
            userInfo.put("userId",user1.getUserId());
            userInfo.put("permission",user1.getPermission());
            res.put("user",userInfo);
            res.put("loginStatus","success");
//            res =  JSON.parseObject("{loginStatus:success,user:{isAdmin:false,userName:\""+user1.getUserName()+"\"," +
//                    "zw:\"" + user1.getZw() + "\"," +
//                    "userId:\"" + user1.getUserId() + "\"," +
//                    "permission:" + user1.getPermission() + "}}");
        }else {
            res.put("loginStatus","failed");
            res.put("errMsg","用户名或密码错误");
//            res =  JSON.parseObject("{loginStatus:failed,errMsg:'用户名或密码错误'}");
        }
        return res;
    }

    /**
     * Description 获取用户列表
     *
     * @author
     * @date 2019-03-22 10:50:47
//     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    @CrossOrigin
    public JSONArray getUserList() {
        List<UserEntity> list = this.userRepository.findAll();
        JSONArray res = new JSONArray();
        list.forEach(userInfo->{
            JSONObject tmpInfo = new JSONObject();
            tmpInfo.put("userId",userInfo.getUserId());
            tmpInfo.put("userName",userInfo.getUserName());
            res.add(tmpInfo);
        });
        String jsonStr = JsonUtil.serializeDate(res);
        return JSON.parseArray(jsonStr);
    }
    @RequestMapping(value = "/allUser")
    @ResponseBody
    @CrossOrigin
    public JSONArray allUser(@RequestBody JSONObject obj) {
        Integer per = obj.getInteger("permission");
        List<UserEntity> list = new ArrayList<UserEntity>();
        UserEntity user = this.userRepository.findUserEntityByUserId(obj.getInteger("userId"));
        list.add(user);
        if (per == 1){
            list.addAll(this.userRepository.findUserEntityByPermission(2));
            list.addAll(this.userRepository.findUserEntityByPermission(3));
        }else if(per == 2){
            list.addAll(this.userRepository.findUserEntityByPermission(3));
        }
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/saveUser")
    @ResponseBody
    @CrossOrigin
    public JSONObject saveUser(@RequestBody UserEntity userEntity) {
        JSONObject res = new JSONObject();
        try {
            this.userRepository.save(userEntity);
            res.put("msg","保存成功");
        }catch (Exception e){
            res.put("msg","保存失败");
        }
        return res;
    }

    @RequestMapping(value = "/removeUser")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject removeUser(@RequestBody JSONObject req){
        JSONObject res = new JSONObject();
        try {
            this.userRepository.deleteUserEntityByUserId(req.getInteger("id"));
            res.put("msg","删除成功");
        }catch (Exception e){
            res.put("msg","删除失败");
        }
        return res;
    }
//
//    @RequestMapping(value = "/removeUser")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject removeUser(@RequestBody Integer id) {
//        JSONObject res = new JSONObject();
//        try {
//            this.userRepository.deleteUserEntityByUserId(id);
//            res.put("msg","删除成功");
//        }catch (Exception e){
//            res.put("msg","删除失败");
//        }
//        return res;
//    }

//
//    @RequestMapping(value = "/addDk")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject addDk(@RequestBody Dk dk) {
//        try{
//            userService.addDk(dk);
//        }catch (Exception e){
//            return JSON.parseObject("{success:false,msg:\"打卡失败！\"}");
//        }
//        return JSON.parseObject("{success:true,msg:\"打卡成功！\"}");
//    }
//
//    @RequestMapping(value = "/getDkList")
//    @ResponseBody
//    @CrossOrigin
//    public JSONArray getDkList(@RequestBody UserDto userDto) {
//        List<UserDto> list = userService.getDkList(userDto);
//        String jsonStr = JsonUtil.serializeDate(list);
//        return JSON.parseArray(jsonStr);
//    }
//
    @RequestMapping(value = "/getHysList")
    @ResponseBody
    @CrossOrigin
    public JSONArray getHysList() {
        List<HysEntity> res = this.hysRepositiory.findAll();
        String jsonStr = JsonUtil.serializeDate(res);
        return JSON.parseArray(jsonStr);
    }
//
//    @RequestMapping(value = "/updateHys")
//    @ResponseBody
//    @CrossOrigin
//    public JSONObject updateHys(Hys hys) {
//        try{
//            userService.updateHys(hys);
//        }catch (Exception e){
//            System.out.println(e);
//            return JSON.parseObject("{success:false,msg:\"更改状态失败！\"}");
//        }
//        return JSON.parseObject("{success:true,msg:\"更改状态成功！\"}");
//    }
//
    @RequestMapping(value = "/kh")
    @ResponseBody
    @CrossOrigin
    public String kh(@RequestBody JSONObject userInfo) throws Exception {
        //List<User> userList = new ArrayList<>();
        JSONArray userIdList = userInfo.getJSONArray("userId");
        for(int i=0;i<userIdList.size();i++){
            UserEntity info = this.userRepository.findUserEntityByUserId(userIdList.getInteger(i));
            try {
                message(info.getPhone(), userInfo.getString("hysbh"), userInfo.getString("time"));
            }catch (Exception e){
                return "false";
            }
        }
        return "true";
    }

//    meetingSave
    @RequestMapping(value = "/meetingSave")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject meetingSave(@RequestBody HysEntity req){
        JSONObject res = new JSONObject();
        try {
            this.hysRepositiory.save(req);
            res.put("msg","删除成功");
        }catch (Exception e){
            res.put("msg","删除失败");
        }
        return res;
    }
//    meetingBatchRemove

    @RequestMapping(value = "/meetingBatchRemove")
    @ResponseBody
    @CrossOrigin
    @Transactional
    public JSONObject meetingBatchRemove(@RequestBody List<HysEntity> req){
        JSONObject res = new JSONObject();
        try {
            this.hysRepositiory.deleteInBatch(req);
            res.put("msg","删除成功");
        }catch (Exception e){
            res.put("msg","删除失败");
        }
        return res;
    }

    private void message(String phone,String hysbh,String time) throws IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = { new NameValuePair("Uid", "dddz97"),
                new NameValuePair("Key", "d41d8cd98f00b204e980"),
                new NameValuePair("smsMob", phone),
                new NameValuePair("smsText", "请于"+time+",到"+hysbh+"开会") };
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result); // 打印返回消息状态

        post.releaseConnection();
    }

}
