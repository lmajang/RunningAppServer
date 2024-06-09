package com.example.runningappserver;

import com.example.runningappserver.Service.*;
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

    @Autowired
    RunRecordService runRecordService;

    @Test
    void contextLoads() {
       System.out.println(friendListService.findAllFriend(8));
    }

}
