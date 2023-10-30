package com.example.feignapi.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    private int role;

}
