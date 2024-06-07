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
@TableName(value="calendar_record")
public class CalendarRecordPojo {
    @TableId(value = "record_id",type = IdType.AUTO)
    Integer recordId;

    @TableField("record_year")
    String recordYear;

    @TableField("record_month")
    String recordMonth;

    @TableField("record_day")
    String recordDay;

    @TableField("upload_id")
    String uploadId;

}
