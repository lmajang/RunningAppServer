package com.example.runningappserver;

import com.example.runningappserver.Pojo.UserRunPojo;
import com.example.runningappserver.Service.ChatService;
import com.example.runningappserver.Service.FriendListService;
import com.example.runningappserver.Service.UserRunService;
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
    UserRunService userRunService;
    @Test
    void contextLoads() {
       userRunService.updateRun("2","2024/6/8","2");
    }

}
