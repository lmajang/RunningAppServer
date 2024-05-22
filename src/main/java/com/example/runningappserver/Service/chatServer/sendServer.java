package com.example.runningappserver.Service.chatServer;

import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class sendServer{
    private Socket socket;

    private JSONObject sendJson;

    private ObjectOutputStream oos;

    public sendServer(Socket socket, JSONObject sendJson, ObjectOutputStream oos){
        this.socket = socket;
        this.sendJson = sendJson;
        this.oos = oos;
    }


    public void sendToSocket(){
        try {
            System.out.println("转发信息给：" + sendJson.get("TargetUserId"));
            oos.writeObject(sendJson);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void sendImageToSocket(String AssetPath){
        try {
            FileInputStream fis = new FileInputStream(AssetPath);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            byte[] bytes = new byte[1024];
            int len = 0;

            while((len = fis.read(bytes)) != -1){
                oos.write(bytes, 0, len);
            }
            oos.flush();
            fis.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
