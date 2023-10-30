package com.example.feignapi.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("homework")
public class TaskEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String description;
    private Date publishTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Integer uId;
    private String commitNum;
    @TableField(exist = false)
    private String uName;

    /**
     * 提交状态
     */
    @TableField(exist = false)
    private int submitStatus;

}
