package com.example.runningappserver.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="user_run")
public class UserRunPojo {
    @TableField("id")
    private String id;
    @TableField("date")
    private String date;
    @TableField("run")
    private String run;
    public String getRun(){return this.run;}

    public void setRun(String run) {this.run=run;}
}
