package com.example.runningappserver.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.runningappserver.Service.FriendNoticeService;
import com.example.runningappserver.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    FriendNoticeService friendNoticeService;
    @RequestMapping(value = "/user1", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public boolean user1(HttpServletRequest req,
                        @RequestParam("id") String id,
                        @RequestParam("avatar") String avatar){
        System.out.println("id:"+id+"   avatar:"+avatar);
        String avatar1=userService.findById(id).getAvatar();
        if(avatar.equals(avatar1)) return false;
        userService.updateAvatar(id,avatar);
        return true;
    }
    @RequestMapping(value = "/user2", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public String user2(HttpServletRequest req,
                         @RequestParam("id") String id){
        System.out.println("id:"+id);
        return JSON.toJSONString(userService.findById(id));
    }
    @RequestMapping(value = "/user3", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public boolean user3(HttpServletRequest req,
                        @RequestParam("id") String id,
                        @RequestParam("target") String target){
        System.out.println("id:"+id+"   target:"+target);
        String target1=userService.findById(id).getTarget();
        if(target.equals(target1)) return false;
        userService.updateTarget(id,target);
        return true;
    }
    @RequestMapping(value = "/user4", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public String user4(HttpServletRequest req,
                        @RequestBody HashMap<String, String> map){
        System.out.println("name:"+map.get("username"));
        return JSON.toJSONString(userService.findByName(map.get("username")));
    }
    @RequestMapping(value = "/user5", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public boolean user5(HttpServletRequest req,
                        @RequestParam("senderid") String senderid,
                        @RequestParam("receiverid") String receiverid){
        System.out.println("senderid:"+senderid+"   receiverid:"+receiverid);
        friendNoticeService.insertFriendNotice(Integer.parseInt(senderid),Integer.parseInt(receiverid));
        return true;
    }
}
