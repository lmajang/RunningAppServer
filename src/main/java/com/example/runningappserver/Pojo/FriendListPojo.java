package com.example.runningappserver.Pojo;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="friendList")
public class FriendListPojo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; // 主键通常不需要@TableField注解，MyBatis-Plus会自动处理
    @TableField("user_id")
    private Integer userId;

    @TableField("friend_id")
    private Integer friendId;

    @TableField("added_at")
    private Timestamp addedAt; // 默认值设置为当前时间

    @TableField("relation")
    private Integer relation;

}
