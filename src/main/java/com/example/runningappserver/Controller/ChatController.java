package com.example.runningappserver.controller;


import com.example.runningappserver.Pojo.ChatPojo;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.Service.ChatService;
import com.example.runningappserver.entily.chatEntity;
import com.example.runningappserver.entily.chatSingleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class ChatController {
    @Autowired
    ChatService chatservice;

    @RequestMapping(value = "/FindAllChat", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<chatSingleEntity> FindAllChat(HttpServletRequest req,
                                              @RequestParam("userId") String userId){
        return chatservice.findAllChat(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/FindNoReceiveChat", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<chatEntity> FindNoReceiveChat(HttpServletRequest req,
                                              @RequestBody HashMap<String, String> map) {
        return chatservice.findNoReceiveChat(Integer.parseInt(map.get("userId")));
    }

    @RequestMapping(value = "/FindFriendChat", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<chatSingleEntity>FindFriendChat(HttpServletRequest req,
                                              @RequestBody HashMap<String, String> map){


        System.out.println(map);
        return chatservice.findFriendChat(Integer.parseInt(map.get("sender_id")),Integer.parseInt(map.get("receiver_id")));
    }

}
