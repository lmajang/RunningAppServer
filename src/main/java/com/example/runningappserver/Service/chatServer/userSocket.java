package com.example.runningappserver.Service.chatServer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class userSocket {
    private String userId;

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private Socket socket;

    public userSocket(String userId, Socket socket, ObjectInputStream ois, ObjectOutputStream oos){
        this.userId = userId;
        this.socket = socket;
        this.ois = ois;
        this.oos = oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUserId() {
        return userId;
    }
}
