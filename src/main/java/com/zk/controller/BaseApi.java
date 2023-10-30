package com.example.userservice.controller;

import com.zk.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class BaseApi {

    public HashMap<String, Object> genResponseResult(int code, Object data, String msg) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", code);
        res.put("data", data);
        res.put("msg", msg);
        return res;
    }


    public UserEntity user(HttpServletRequest request) {
        return (UserEntity) request.getSession().getAttribute("curr_user");
    }

}
