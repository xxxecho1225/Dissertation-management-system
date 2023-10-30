package com.example.userservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PageController {


    @GetMapping("/login_zhoukai")
    public String login() {
        return "/login";
    }


    @GetMapping("/no-auth_zhoukai")
    public String noAuth() {
        return "/no-auth";
    }

    @GetMapping("/student_zhoukai")
    public String student() {
        return "/student";
    }


    @GetMapping("/teacher_zhoukai")
    public String teacher() {
        return "/teacher";
    }

    @GetMapping("/home_zhoukai")
    public String admin() {
        return "home";
    }


    @GetMapping("/system-log_zhoukai")
    public String systemLog() {
        return "/system-log";
    }


    @GetMapping("/logout_zhoukai")
    public String systemLog(HttpServletRequest request) {
        request.getSession().removeAttribute("curr_user_zhoukai");
        return "/login";
    }

    @GetMapping("/modify-password_zhoukai")
    public String modifyPassword() {
        return "/modify-password";
    }


}
