package com.example.runningappserver.Service.chatServer;
import org.json.simple.JSONObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class chatService {

    private static Map<String,userSocket> socketMap= new HashMap<>();

    public static userSocket getConnectSocketId(String userId){
        return socketMap.get(userId);
    }

    public static userSocket deleteConnectSocketId(String userId){
        return socketMap.remove(userId);
    }

    public static void startChatService(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("chatServer Start");
            while(true) {
                Socket socket = serverSocket.accept();
//                InetAddress addr = socket.getInetAddress();
                InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                //获取连接socket的id
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                JSONObject json = (JSONObject)ois.readObject();
                String UserId = (String)json.get("userId");

                userSocket us = new userSocket(UserId, socket, ois, oos);

                socketMap.put(UserId, us);

                System.out.println("UserId登录: " + UserId);

                System.out.println("connection from: " + socketAddress.getHostName()+'\t'+socketAddress.getAddress().getHostAddress()
                        +":"+socketAddress.getPort());

                JSONObject connectResult = new JSONObject();
                connectResult.put("type", "connectStatus");
                connectResult.put("success", 200);

                oos.writeObject(connectResult);
                oos.flush();
                System.out.println("socketMap:"+socketMap);

                new Thread(new listenServer(us)).start();

//                new Thread(new sendServer(socket)).start();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


