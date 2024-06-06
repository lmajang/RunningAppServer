package com.example.runningappserver.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.runningappserver.Pojo.FriendListPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FriendListDao extends BaseMapper<FriendListPojo> {
}
