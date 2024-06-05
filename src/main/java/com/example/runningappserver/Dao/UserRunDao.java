package com.example.runningappserver.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.runningappserver.Pojo.UserPojo;
import com.example.runningappserver.Pojo.UserRunPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRunDao extends BaseMapper<UserRunPojo> {
}
