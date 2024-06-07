package com.example.runningappserver.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public String login(HttpServletRequest req,
                        @RequestParam("mail") String mail,
                        @RequestParam("pwd") String pwd){
          System.out.println("mail:"+mail+"   pwd:"+pwd);
          String password=userService.findByMail(mail).getPassword();
          UserPojo userPojo=userService.findByMail(mail);
          if(password.equals(pwd)) return JSON.toJSONString(userPojo);
          return "0";
    }
    @RequestMapping(value = "/register", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public void register(HttpServletRequest req,
                        @RequestParam("mail") String mail,
                        @RequestParam("pwd") String pwd,
                         @RequestParam("name")String name) {
        System.out.println("mail:"+mail+"   pwd:"+pwd);
        userService.addUser(mail,pwd,name);
    }
    @RequestMapping(value = "/forget", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public boolean foeget(HttpServletRequest req,
                         @RequestParam("mail") String mail,
                         @RequestParam("pwd") String pwd){
        System.out.println("mail:"+mail+"   pwd:"+pwd);
        String password=userService.findByMail(mail).getPassword();
        if(password.equals(pwd)) return false;
        userService.updateUser(mail,pwd);
        return true;
    }
}
