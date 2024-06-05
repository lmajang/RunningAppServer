package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.UserDao;
import com.example.runningappserver.Pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public UserPojo findById(String id){return userDao.selectById(id);}
    public UserPojo findByMail(String mail){
        QueryWrapper<UserPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("mail",mail);
        return userDao.selectOne(wrapper);
    }
    public void addUser(String mail,String pwd,String name){
        //Long num=userDao.selectCount(new QueryWrapper<>())+1;
        userDao.insert(new UserPojo(null,mail,pwd,name,null,null));
    }

    public void updateUser(String mail, String pwd) {
        UserPojo userPojo=new UserPojo();
        userPojo.setPassword(pwd);
        QueryWrapper<UserPojo> wrapper=new QueryWrapper<>();
        wrapper.eq("mail",mail);
        userDao.update(userPojo,wrapper);
    }
}
