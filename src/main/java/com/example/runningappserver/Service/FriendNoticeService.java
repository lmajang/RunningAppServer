package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.FriendNoticeDao;
import com.example.runningappserver.Pojo.FriendNoticePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class FriendNoticeService {
    @Autowired
    FriendNoticeDao friendNoticeDao;

    public Integer insertFriendNotice(Integer senderId, Integer reciverId){
        return friendNoticeDao.insert(new FriendNoticePojo(null,senderId,reciverId,null,null));
    }

    public Integer refuseFriendNotice(Integer noticeId){
        return friendNoticeDao.updateById(new FriendNoticePojo(noticeId,null,null,-1,null));
    }

    public Integer agreeFriendNotice(Integer noticeId){
        return friendNoticeDao.updateById(new FriendNoticePojo(noticeId,null,null,1,null));
    }
}
