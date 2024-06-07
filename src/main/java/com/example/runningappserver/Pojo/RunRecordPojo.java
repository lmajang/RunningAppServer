package com.example.runningappserver.Pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="run_record")
public class RunRecordPojo {
    @TableId(value = "record_id",type = IdType.AUTO)
    Integer recordId;

    @TableField("target_distance")
    String targetDistance;

    @TableField("ran_distance")
    String RanDistance;

    @TableField("spend_time")
    String spendTime;

    @TableField("start_time")
    String startTime;

    @TableField("run_line")
    String runLine;

    @TableField("speed")
    String speed;

    @TableField("address")
    String address;

    @TableField("cadence")
    String cadence;

    @TableField("upload_time")
    String uploadTime;

    @TableField("runner_id")
    String runnerId;

}
