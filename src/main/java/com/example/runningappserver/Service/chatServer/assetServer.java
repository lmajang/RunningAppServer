package com.example.runningappserver.Service.chatServer;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class assetServer {
    private ObjectInputStream ois;
    private FileOutputStream fos;
    public assetServer(ObjectInputStream ois){
        this.ois = ois;
    }

    public void saveAsset(String assetPath){
        try {
            fos = new FileOutputStream(assetPath);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = ois.read(bytes))!=-1){
                fos.write(bytes, 0, len);
            }

            fos.close();
            System.out.println("保存图片成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
