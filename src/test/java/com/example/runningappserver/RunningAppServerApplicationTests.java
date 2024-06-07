package com.example.runningappserver;

import com.example.runningappserver.Service.ChatService;
import com.example.runningappserver.Service.FriendListService;
import com.example.runningappserver.Service.FriendNoticeService;
import com.example.runningappserver.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RunningAppServerApplicationTests {
    @Autowired
    FriendListService friendListService;
    @Autowired
    UserService userService;
    @Autowired
    ChatService chatService;
    @Autowired
    FriendNoticeService friendNoticeService;
    @Test
    void contextLoads() {
        friendNoticeService.insertFriendNotice(Integer.parseInt("2"),Integer.parseInt("1"));
    }

}
