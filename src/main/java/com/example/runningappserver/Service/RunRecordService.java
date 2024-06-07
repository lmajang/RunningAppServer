package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.runningappserver.Dao.RunRecordDao;
import com.example.runningappserver.Pojo.RunRecordPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunRecordService {
    @Autowired
    RunRecordDao runRecordDao;

    public List<RunRecordPojo> findAllRunRecords(String userId){
        QueryWrapper<RunRecordPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("runner_id",userId).orderBy(true,true,"upload_time");
        return runRecordDao.selectList(wrapper);
    }

//    public Integer upLoadRunRecord()
}
