package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.UserRunDao;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.Pojo.UserRunPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRunService {
    @Autowired
    UserRunDao userRunDao;
    public UserRunPojo find(String id,String date){
        QueryWrapper<UserRunPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("userid",id);
        wrapper.eq("date",date);
        UserRunPojo userRunPojo=new UserRunPojo();
        userRunPojo.setRun("0");
        if(userRunDao.selectCount(wrapper)==0) return userRunPojo;
        return userRunDao.selectOne(wrapper);
    }
    public Integer updateRun(String id,String date,String run){
        QueryWrapper<UserRunPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("userid",id);
        wrapper.eq("date",date);
        if(userRunDao.selectCount(wrapper)==0) return userRunDao.insert(new UserRunPojo(null,id,date,run));
        else {
            UserRunPojo userPojo = userRunDao.selectOne(wrapper);
            String run0 = userPojo.getRun();
            String res=String.valueOf(Double.parseDouble(run)+Double.parseDouble(run0));
            userPojo.setRun(res);
            return userRunDao.update(userPojo,wrapper);
        }
    }
}
