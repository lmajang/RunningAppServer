package com.example.runningappserver.Service.chatServer;

import com.example.runningappserver.Service.ChatService;
import com.example.runningappserver.controller.ChatController;
import com.example.runningappserver.tool.SpringUtil;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.net.Socket;




public class listenServer implements Runnable{
    private userSocket userSocket;


    public listenServer(userSocket userSocket){
        this.userSocket = userSocket;
    }
    private ApplicationContext context = SpringUtil.getApplicationContext();
    private ChatService chatservice = context.getBean(ChatService.class);

    @Override
    public void run() {
        try {
            while (true) {
                JSONObject json = (JSONObject)userSocket.getOis().readObject();
                if(json.get("type").equals("chat")) {
                    System.out.println("chat信息：" + json);
                    String userId = (String) json.get("userId");
                    String targetUserId = (String) json.get("TargetUserId");
                    String msg = (String)json.get("msg");
                    userSocket targetSocket = chatService.getConnectSocketId(targetUserId);
                    System.out.println(targetSocket);
                    if (targetSocket != null) {
                        sendServer sendMsg = new sendServer(targetSocket.getSocket(), json, targetSocket.getOos());
                        sendMsg.sendToSocket();
                        chatservice.insertChat(Integer.parseInt(userSocket.getUserId()),Integer.parseInt(targetUserId),msg,1);
                    } else {
                        //对方没上线，处理
                        chatservice.insertChat(Integer.parseInt(userSocket.getUserId()),Integer.parseInt(targetUserId),msg,0);
                        System.out.println("对方不在线");
                    }
                }else if(json.get("type").equals("image")){
                    String AssetPath = "src/main/resources/assets/testImage.jpg";
                    String targetUserId = (String) json.get("TargetUserId");
                    System.out.println(targetUserId);
                    if (targetUserId != null) {
                        Socket targetSocket = chatService.getConnectSocketId(targetUserId).getSocket();
                        assetServer asset = new assetServer(userSocket.getOis());
                        asset.saveAsset(AssetPath);
//                        sendServer sendImg = new sendServer(targetSocket, json);
//                        sendImg.sendImageToSocket(AssetPath);

                    }else{
                        //对方没上线，处理
                        System.out.println("对方不在线");
                    }

                }else{
//                    oos.writeObject(json);
//                    oos.flush();
                    System.out.println("信息：" + json);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                userSocket.getSocket().close();
                chatService.deleteConnectSocketId(userSocket.getUserId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
