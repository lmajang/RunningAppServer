package com.example.runningappserver.entily;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class chatSingleEntity {

    private Integer senderId;


    private Integer receiverId;


    private String message;

    private Timestamp timestamp;

}
