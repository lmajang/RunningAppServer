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
@TableName(value="user")
public class UserPojo {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;
    @TableField("mail")
    private String mail;
    @TableField("password")
    private String pwd;
    @TableField("username")
    private String name;
    public String getPassword() {return this.pwd;}
    public String getId() {return this.id;}
    public void setPassword(String pwd) {this.pwd=pwd;}
}
