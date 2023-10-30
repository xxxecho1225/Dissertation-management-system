package com.zk.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.entity.SystemLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SystemLogMapper extends BaseMapper<SystemLogEntity> {


    @Select("select option_name, url, cost_time, from_unixtime(start_time / 1000, '%Y-%m-%d %H:%i:%S') as start_time,tu.user_name from system_log tsl left join users tu on tu.id = tsl.u_id")
    List<Map<String, String>> listMap();

}
