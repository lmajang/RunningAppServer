package com.example.runningappserver.controller;

import com.example.runningappserver.Pojo.CalendarRecordPojo;
import com.example.runningappserver.Service.CalendarRecordService;
import com.example.runningappserver.entily.chatSingleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class CalendarRecordController {
    @Autowired
    CalendarRecordService calendarRecordService;

    @RequestMapping(value = "/setCalendarRecord", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public Integer setCalendarRecord(HttpServletRequest req,
                                     @RequestBody HashMap<String, String> map){
        return calendarRecordService.setCalendarsRecord(map.get("userId"),map.get("year"),map.get("month"),map.get("day"));
    }

    @RequestMapping(value = "/findAllCalendarRecord", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<CalendarRecordPojo> findAllCalendarRecord(HttpServletRequest req,
                                                          @RequestBody HashMap<String, String> map){
        return calendarRecordService.findAllCalendarsRecord(map.get("userId"));
    }
}
