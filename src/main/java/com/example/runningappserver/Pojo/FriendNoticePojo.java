package com.example.runningappserver.Pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="friend_notice")
public class FriendNoticePojo {
    @TableId(value = "notice_id",type = IdType.AUTO)
    Integer noticeId;
    @TableField("sender_id")
    Integer senderId;

    @TableField("receiver_id")
    Integer receiverId;

    @TableField("receiver_status")
    Integer receiveStatus;

    @TableField("send_time")
    Timestamp sendTime;
}
