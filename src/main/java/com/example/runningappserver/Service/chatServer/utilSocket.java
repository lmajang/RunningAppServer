package com.example.runningappserver.Service.chatServer;

import org.json.simple.JSONObject;

public class utilSocket {
    static public void closeConnectSocket(String userId){
        userSocket socket = chatService.getConnectSocketId(userId);
        try {
            JSONObject connectResult = new JSONObject();
            connectResult.put("type", "disConnectStatus");
            socket.getOos().writeObject(connectResult);
            socket.getOos().flush();
            socket.getSocket().close();
            System.out.println("userId:"+socket.getUserId()+" closeSocket");
            chatService.deleteConnectSocketId(userId);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
