package com.example.runningappserver.controller;

import com.example.runningappserver.Pojo.RunRecordPojo;
import com.example.runningappserver.Service.CalendarRecordService;
import com.example.runningappserver.Service.RunRecordService;
import com.example.runningappserver.entily.friendEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class RunRecordController {
    @Autowired
    RunRecordService runRecordService;

    @RequestMapping(value = "/uploadRunRecord", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public Integer uploadRunRecord(HttpServletRequest req,
                                           @RequestBody HashMap<String, String> map){

        System.out.println(map);
        return runRecordService.upLoadRunRecord(
                map.get("targetDistance"),
                map.get("RanDistance"),
                map.get("spendTime"),
                map.get("startTime"),
                map.get("runLine"),
                map.get("speed"),
                map.get("address"),
                map.get("cadence"),
                map.get("runnerId")
        );
    }

    @RequestMapping(value = "/findAllRecord", produces = "application/json; charset=UTF-8",method = RequestMethod.POST)
    public List<RunRecordPojo> findAllRecord(HttpServletRequest req,
                                             @RequestBody HashMap<String, String> map){
        List<RunRecordPojo> result = runRecordService.findAllRunRecords(map.get("userId"));
        if(result.isEmpty()) return null;
        return result;
    }
}
