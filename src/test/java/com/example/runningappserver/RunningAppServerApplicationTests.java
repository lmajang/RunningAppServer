package com.example.runningappserver;

import com.example.runningappserver.Service.ChatService;
import com.example.runningappserver.Service.FriendListService;
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
    @Test
    void contextLoads() {
       System.out.println(chatService.findFriendChat(1,2));
    }

}
