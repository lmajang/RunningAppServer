package com.example.runningappserver.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.FriendListDao;
import com.example.runningappserver.Dao.UserDao;
import com.example.runningappserver.Pojo.FriendListPojo;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.entily.friendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class FriendListService {
    @Autowired
    FriendListDao friendListDao;

    @Autowired
    UserDao userDao;

    public Timestamp findUpdateTime(Integer userId){
        QueryWrapper<FriendListPojo> wrapper = new QueryWrapper<>();
        wrapper.select("MAX(addedAt)").eq("user_id",userId).or().eq("friend_id",userId);
        FriendListPojo friendList = friendListDao.selectOne(wrapper);
        return friendList.getAddedAt();
    }

    public List<friendEntity> searchUser(String username){
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        wrapper.like("username",username);
        List<UserPojo> userList = userDao.selectList(wrapper);
        List<friendEntity> friendlist = new ArrayList<>();
        for (UserPojo user : userList) {
            friendlist.add(new friendEntity(String.valueOf(user.getId()),user.getAvatar(),user.getName()));
        }
        return friendlist;
    }

    public List<friendEntity> findAllFriend(Integer userId){
        QueryWrapper<FriendListPojo> wrapperFriend = new QueryWrapper<>();
        QueryWrapper<UserPojo> wrapperUser = new QueryWrapper<>();
        wrapperFriend.or(i -> i.eq("user_id",userId).select("friend_id"))
                .or(i->i.eq("friend_id",userId).select("user_id"));
        List<FriendListPojo> friendList = friendListDao.selectList(wrapperFriend);
        // 提取查询结果中的另一半ID
        List<Integer> otherHalfIds = new ArrayList<>();
        for (FriendListPojo result : friendList) {
            if (result.getUserId() != null && result.getUserId().equals(userId)) {
                otherHalfIds.add(result.getFriendId());
            } else if (result.getFriendId() != null && result.getFriendId().equals(userId)) {
                otherHalfIds.add(result.getUserId());
            }
        }
        List<friendEntity> friendlist = new ArrayList<>();
        List<UserPojo> userList = userDao.selectBatchIds(otherHalfIds);
        for (UserPojo user : userList) {
            friendlist.add(new friendEntity(String.valueOf(user.getId()),user.getAvatar(),user.getName()));
        }
        return friendlist;
    }

    public int insertFriend(Integer userId,Integer friendId){
        return friendListDao.insert(new FriendListPojo(null,userId,friendId,null,null));
    }

}
