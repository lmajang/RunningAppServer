package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.FriendNoticeDao;
import com.example.runningappserver.Dao.UserDao;
import com.example.runningappserver.Pojo.FriendNoticePojo;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.entily.friendNoticeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FriendNoticeService {
    @Autowired
    FriendNoticeDao friendNoticeDao;
    @Autowired
    UserDao userDao;

    @Autowired
    FriendListService friendListService;

    public Integer insertFriendNotice(Integer senderId, Integer reciverId){
        return friendNoticeDao.insert(new FriendNoticePojo(null,senderId,reciverId,null,null));
    }

    public Integer refuseFriendNotice(String senderId, String receiverId){
        QueryWrapper<FriendNoticePojo> wrapper = new QueryWrapper<>();
        wrapper.eq("sender_id",senderId).eq("receiver_id",receiverId).or()
                .eq("sender_id",receiverId).eq("receiver_id",senderId);
        return friendNoticeDao.update(new FriendNoticePojo(null,null,null,-1,null),wrapper);
    }

    public Integer agreeFriendNotice(String senderId, String receiverId){
        QueryWrapper<FriendNoticePojo> wrapper = new QueryWrapper<>();
        wrapper.eq("sender_id",senderId).eq("receiver_id",receiverId).or()
                .eq("sender_id",receiverId).eq("receiver_id",senderId);
        int updateStatus = friendNoticeDao.update(new FriendNoticePojo(null,null,null,1,null),wrapper);
        if (updateStatus == 0) return 0;
        return friendListService.insertFriend(Integer.parseInt(senderId),Integer.parseInt(receiverId));
    }

    public List<friendNoticeEntity> findAllFriendNotice(String userId){
        QueryWrapper<FriendNoticePojo> wrapper = new QueryWrapper<>();
        wrapper.eq("receiver_id",userId).eq("receiver_status",0);
        List<FriendNoticePojo> friendNoticePojoList = friendNoticeDao.selectList(wrapper);
        List<Integer> receiverId = new ArrayList<>();
        List<friendNoticeEntity> list = new ArrayList<>();
        List<String> noticeIds = new ArrayList<>();
        for (FriendNoticePojo friendNotice: friendNoticePojoList) {
            receiverId.add(friendNotice.getSenderId());
            noticeIds.add(String.valueOf(friendNotice.getNoticeId()));
        }
        if(!receiverId.isEmpty()){
            List<UserPojo> userList = userDao.selectBatchIds(receiverId);
            for (int i = 0; i < userList.size(); i++) {
                list.add(new friendNoticeEntity(noticeIds.get(i),userList.get(i).getId(),
                        userList.get(i).getAvatar(),userList.get(i).getName(),userList.get(i).getMessage()));
            }
        }
        return list;
    }

    public Integer haveNewNotice(String userId){
        QueryWrapper<FriendNoticePojo> wrapper = new QueryWrapper<>();
        wrapper.eq("receiver_id",userId).eq("receiver_status",0);
        FriendNoticePojo friendNoticePojo = friendNoticeDao.selectOne(wrapper);
        if (friendNoticePojo==null){
            return 0;
        }else {
            return 1;
        }
    }
}
