package com.example.runningappserver.controller;

import com.example.runningappserver.Service.FriendListService;
import com.example.runningappserver.entily.friendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class FriendListController {
    @Autowired
    FriendListService friendListService;

    @RequestMapping(value = "/SearchUser", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<friendEntity> SearchUser(HttpServletRequest req,
                                         @RequestBody HashMap<String, String> map){
        List<friendEntity> userList = friendListService.searchUser(map.get("username"));
        return userList;
    }

    @RequestMapping(value = "/addFriend", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public int addFriend(HttpServletRequest req,
                                @RequestParam("userId") String userId,
                                @RequestParam("friendId") String friendId){

        return friendListService.insertFriend(Integer.parseInt(userId),Integer.parseInt(friendId));
    }

    @RequestMapping(value = "/getAllFriend", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<friendEntity> getAllFriend(HttpServletRequest req,
                                           @RequestBody HashMap<String, String> map){
        System.out.println(map);
        return friendListService.findAllFriend(Integer.parseInt(map.get("userId")));
    }

}
