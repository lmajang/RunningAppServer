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
@TableName(value="chat")
public class ChatPojo {
    @TableId(value = "chat_id",type = IdType.AUTO)
    private Integer chatId;

    @TableField("sender_id") // 映射sender_id列
    private Integer senderId;

    @TableField("receiver_id") // 映射receiver_id列
    private Integer receiverId;

    @TableField("message") // 映射message列
    private String message;

    @TableField("timestamp") // 映射timestamp列
    private Timestamp timestamp;

    @TableField("receive_status")
    private Integer receiveStatus;
}
