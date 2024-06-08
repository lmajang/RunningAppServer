package com.example.runningappserver.Service;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
        System.out.println(runRecordDao.selectList(wrapper));
        return runRecordDao.selectList(wrapper);
    }

    public Integer upLoadRunRecord(String targetDistance,
                                   String RanDistance,
                                   String spendTime,
                                   String startTime,
                                   String runLine,
                                   String speed,
                                   String address,
                                   String cadence,
                                   String runnerId){
        return runRecordDao.insert(new RunRecordPojo(null,targetDistance,
                RanDistance,
                spendTime,
                startTime,
                runLine,
                speed,
                address,
                cadence,
                null,
                runnerId));
    }

}
