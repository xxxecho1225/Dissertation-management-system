package com.zk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.entity.SystemLogEntity;
import com.zk.mapper.SystemLogMapper;
import com.zk.service.ISystemLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLogEntity> implements ISystemLogService {

    @Override
    public List<Map<String, String>> listMap() {
        return baseMapper.listMap();
    }
}
