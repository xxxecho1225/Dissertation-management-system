package com.example.userservice.controller;


import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zk.entity.UserEntity;
import com.zk.service.IUserService;
import com.zk.service.impl.SendMailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("/api")
public class LoginApi extends BaseApi {


    private IUserService userService;

    private SendMailServiceImpl sendMailService;

    @PostMapping("/modify-password")
    public HashMap<String, Object> modifyPassword(@RequestParam Map<String, String> params, HttpServletRequest request) {
        log.info("params = {}", params);
        String oldPassword = params.get("old_password");
        String newPassword = params.get("new_password");
        if (Objects.isNull(oldPassword) || oldPassword.trim().length() == 0) {
            return genResponseResult(400, null, "旧密码不能为空");
        }
        if (Objects.isNull(newPassword) || newPassword.trim().length() == 0) {
            return genResponseResult(400, null, "新密码不能为空");
        }
        HttpSession session = request.getSession();
        UserEntity user = user(request);

        oldPassword = SecureUtil.md5(oldPassword);
        newPassword = SecureUtil.md5(newPassword);

        if (!user.getPassword().equals(oldPassword)) {
            return genResponseResult(400, null, "旧密码填写错误");
        }
        if (user.getPassword().equals(newPassword)) {
            return genResponseResult(400, null, "新旧密码不能一致");
        }
        user.setPassword(newPassword);
        boolean res = userService.updateById(user);
        if (res) {
            session.removeAttribute("curr_user");
            return genResponseResult(200, null, "修改成功");
        }
        return genResponseResult(400, null, "修改失败");
    }


    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestParam Map<String, String> params, HttpServletRequest request) {
        log.info("params = {}", params);
        String userName = params.get("user_name");
        String password = params.get("password");
        String authCode = params.get("auth_code");
        if (Objects.isNull(userName) || userName.trim().length() == 0) {
            return genResponseResult(400, null, "用户名不能为空");
        }
        if (Objects.isNull(password) || password.trim().length() == 0) {
            return genResponseResult(400, null, "密码不能为空");
        }
        if (Objects.isNull(authCode) || authCode.trim().length() == 0) {
            return genResponseResult(400, null, "验证码不能为空");
        }

        HttpSession session = request.getSession();
        String authCode_ = (String) session.getAttribute("auth-code");
        log.info("authCode_ = {}", authCode_);
        if (!authCode.equals(authCode_)) {
            return genResponseResult(400, null, "验证码错误");
        }
        session.removeAttribute("auth-coded");
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();

        password = SecureUtil.md5(password);
        wrapper.eq("user_name", userName);
        wrapper.eq("password", password);
        UserEntity user = userService.getOne(wrapper);
        log.info("user-list = {}", userService.list());
        if (Objects.isNull(user)) {
            return genResponseResult(404, null, "用户不存在 或 账号名密码错误");
        }
        session.setAttribute("curr_user", user);
        HashMap<String, String> data = new HashMap<>();
        data.put("jump_url", "/home_zhoukai");
        return genResponseResult(200, data, "登录成功");
    }


    @PostMapping("/login/send")
    public HashMap<String, Object> send(@RequestParam Map<String, String> params, HttpServletRequest request) {
        String email = (String) params.get("email");
        log.info("params = {}", params);

        if (Objects.isNull(email) || email.trim().length() == 0) {
            return genResponseResult(400, null, "邮箱不能为空");
        }
        HttpSession session = request.getSession();
        String authCode = (Math.round(Math.random() * 9000) + 1000) + "";
        session.setAttribute("auth-code", authCode);
        sendMailService.sendHtmlMail(email, "验证码", authCode);
        return genResponseResult(200, null, "success");
    }


    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSendMailService(SendMailServiceImpl sendMailService) {
        this.sendMailService = sendMailService;
    }
}
