package com.zk.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("system_log")
public class SystemLogEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String url;
    private long startTime;

    private long endTime;

    private long uId;

    private long costTime;

    private String optionName;

}
