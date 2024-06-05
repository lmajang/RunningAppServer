package com.example.runningappserver;

import com.alibaba.fastjson2.JSON;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RunningAppServerApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.addUser("123123","123","123");
    }

}
