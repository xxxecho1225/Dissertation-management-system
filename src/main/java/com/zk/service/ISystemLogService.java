package com.zk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.entity.SystemLogEntity;

import java.util.List;
import java.util.Map;

public interface ISystemLogService extends IService<SystemLogEntity> {


    List<Map<String,String>> listMap();
 }
