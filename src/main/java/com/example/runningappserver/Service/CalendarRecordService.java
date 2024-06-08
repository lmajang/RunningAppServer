package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.CalendarRecordDao;
import com.example.runningappserver.Pojo.CalendarRecordPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarRecordService {
    @Autowired
    CalendarRecordDao calendarRecordDao;
    public List<CalendarRecordPojo> findAllCalendarsRecord(String userId){
        QueryWrapper<CalendarRecordPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("upload_id", userId);
        return calendarRecordDao.selectList(wrapper);
    }

    public Integer setCalendarsRecord(String userId, String year, String month, String day){
        return calendarRecordDao.insert(new CalendarRecordPojo(null,year,month,day,userId));
    }

    public Integer isCalendarsRecord(String userId, String year, String month, String day){
        QueryWrapper<CalendarRecordPojo> wrapper =new QueryWrapper<>();
        wrapper.eq("record_year",year).eq("record_month",month).eq("record_day",day).eq("upload_id",userId);
        CalendarRecordPojo calendarRecordPojo = calendarRecordDao.selectOne(wrapper);
        if (calendarRecordPojo == null) return 0;
        return 1;
    }

}
