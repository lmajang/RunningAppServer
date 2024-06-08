package com.example.runningappserver.controller;

import com.example.runningappserver.Service.FriendNoticeService;
import com.example.runningappserver.entily.friendEntity;
import com.example.runningappserver.entily.friendNoticeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class FriendNoticeController {
    @Autowired
    FriendNoticeService friendNoticeService;

    @RequestMapping(value = "/findAllFriendNotice", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<friendNoticeEntity> findAllFriendNotice(HttpServletRequest req,
                                                        @RequestBody HashMap<String, String> map){
        return friendNoticeService.findAllFriendNotice(map.get("userId"));
    }

    @RequestMapping(value = "/refuseFriendNotice", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public Integer refuseFriendNotice(HttpServletRequest req,
                                         @RequestBody HashMap<String, String> map){
        return friendNoticeService.refuseFriendNotice(map.get("senderId"),map.get("receiverId"));
    }

    @RequestMapping(value = "/agreeFriendNotice", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public Integer agreeFriendNotice(HttpServletRequest req,
                                         @RequestBody HashMap<String, String> map){
        return friendNoticeService.agreeFriendNotice(map.get("senderId"),map.get("receiverId"));
    }

    @RequestMapping(value = "/haveNewNotice", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public Integer haveNewNotice(HttpServletRequest req,
                                     @RequestBody HashMap<String, String> map){
        return friendNoticeService.haveNewNotice(map.get("userId"));
    }


}
