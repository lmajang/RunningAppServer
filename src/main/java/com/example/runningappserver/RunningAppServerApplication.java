package com.example.runningappserver;

import com.example.runningappserver.Service.chatServer.chatService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class RunningAppServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(RunningAppServerApplication.class, args);
        chatService.startChatService(9999);
    }

}
