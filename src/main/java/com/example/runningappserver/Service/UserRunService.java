package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.UserRunDao;
import com.example.runningappserver.Pojo.UserRunPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRunService {
    @Autowired
    UserRunDao userRunDao;
    public UserRunPojo find(String id,String date){
        QueryWrapper<UserRunPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id);
        wrapper.eq("date",date);
        UserRunPojo userRunPojo=new UserRunPojo();
        userRunPojo.setRun("0");
        if(userRunDao.selectCount(wrapper)==0) return userRunPojo;
        return userRunDao.selectOne(wrapper);
    }
}
