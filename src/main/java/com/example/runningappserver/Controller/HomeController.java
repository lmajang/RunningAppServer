package com.example.runningappserver.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.Pojo.UserRunPojo;
import com.example.runningappserver.Service.UserRunService;
import com.example.runningappserver.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    UserRunService userRunService;
    @RequestMapping(value = "/home1" , produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public String home1(HttpServletRequest req,
                        @RequestParam("id") String id){
        System.out.println("id:"+id);
        return JSON.toJSONString(userService.findById(id));
    }
    @RequestMapping(value = "/home2" , produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public String home2(HttpServletRequest req,
                        @RequestParam("id") String id,
                        @RequestParam("date") String date){
        System.out.println("id:"+id+"    date:"+date);
        return userRunService.find(id,date).getRun();
    }
}
