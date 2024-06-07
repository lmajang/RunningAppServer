package com.example.runningappserver.Service.chatServer;

public class utilSocket {
    static public void closeConnectSocket(String userId){
        userSocket socket = chatService.getConnectSocketId(userId);
        try {
            socket.getSocket().close();
            System.out.println("userId:"+socket.getUserId()+" closeSocket");
            chatService.deleteConnectSocketId(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
