package com.example.userservice.controller;


import com.zk.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/log")
public class SystemLogApi extends BaseApi {

    private ISystemLogService systemLogService;

    @GetMapping("list")
    public HashMap<String, Object> logList() {
        return genResponseResult(200, systemLogService.listMap(), "ok");
    }


    @Autowired
    public void setSystemLogService(ISystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }
}
