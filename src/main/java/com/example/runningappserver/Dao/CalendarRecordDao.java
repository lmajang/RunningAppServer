package com.example.runningappserver.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.runningappserver.Pojo.CalendarRecordPojo;
import com.example.runningappserver.Pojo.RunRecordPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CalendarRecordDao extends BaseMapper<CalendarRecordPojo> {
}
