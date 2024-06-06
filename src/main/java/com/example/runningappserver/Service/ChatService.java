package com.example.runningappserver.Service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.ChatDao;
import com.example.runningappserver.Pojo.ChatPojo;
import com.example.runningappserver.Pojo.FriendListPojo;
import com.example.runningappserver.Service.chatServer.chatService;
import com.example.runningappserver.Service.chatServer.userSocket;
import com.example.runningappserver.entily.chatEntity;
import com.example.runningappserver.entily.chatSingleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    ChatDao chatDao;

    public List<chatSingleEntity> findAllChat(Integer userId){
        QueryWrapper<ChatPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("receiver_id",userId).or()
                .eq("sender_id",userId);
        List<ChatPojo> list = chatDao.selectList(wrapper);
        List<chatSingleEntity> clist = new ArrayList<>();
        for (ChatPojo chatPojo: list){
            clist.add(new chatSingleEntity(chatPojo.getSenderId(),chatPojo.getReceiverId(),chatPojo.getMessage(),chatPojo.getTimestamp()));
        }
        return clist;

    }

    public List<chatEntity> findNoReceiveChat(Integer userId){
        QueryWrapper<ChatPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("receiver_id", userId).eq("receive_status",0);
        List<ChatPojo> list = chatDao.selectList(wrapper);
        List<chatEntity> chatEntityList = new ArrayList<>();
        chatDao.update(new ChatPojo(null,null,null,null,null,1),wrapper.eq("receiver_id", userId));
        for(ChatPojo chat:list){
            chatEntityList.add(new chatEntity(String.valueOf(chat.getReceiverId()),chat.getMessage(),chatEntity.RECEIVE));
        }
        return chatEntityList;
    }

    public Integer insertChat(Integer senderId, Integer receiverId, String msg, Integer receiveStatus){
        return chatDao.insert(new ChatPojo(null,senderId,receiverId,msg,null,receiveStatus));
    }

    public List<chatSingleEntity> findFriendChat(Integer senderId, Integer receiverId){
        QueryWrapper<ChatPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("receiver_id",senderId).eq("sender_id",receiverId).or().
                eq("sender_id",senderId).eq("receiver_id",receiverId);
        List<ChatPojo> list = chatDao.selectList(wrapper);
        List<chatSingleEntity> clist = new ArrayList<>();
        for (ChatPojo chatPojo: list){
            clist.add(new chatSingleEntity(chatPojo.getSenderId(),chatPojo.getReceiverId(),chatPojo.getMessage(),chatPojo.getTimestamp()));
        }
        return clist;

    }
}
