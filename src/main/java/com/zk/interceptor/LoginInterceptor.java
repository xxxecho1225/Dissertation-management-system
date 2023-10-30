package com.example.feignapi.util;

import com.zk.entity.SystemLogEntity;
import com.zk.entity.UserEntity;
import com.zk.service.ISystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    private ISystemLogService service;


    // 访问 Controller 前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取 session 种存放的 session
        UserEntity user = (UserEntity) request.getSession().getAttribute("curr_user");

        if (Objects.isNull(user)) {
            response.sendRedirect("/login_zhoukai");
            return false;
        }

        // 限制页面访问
        if ((request.getRequestURI().startsWith("/system-log")) && user.getRole() != 1) {
            response.sendRedirect("/no-auth_zhoukai");
        }

        if (request.getRequestURI().startsWith("/teacher") && user.getRole() != 2) {
            response.sendRedirect("/no-auth_zhoukai");
        }

        if (request.getRequestURI().startsWith("/student") && user.getRole() != 3) {
            response.sendRedirect("/no-auth_zhoukai");
        }


        if (request.getRequestURI().startsWith("/api")) {
            long start = System.currentTimeMillis();
            request.setAttribute("startTime", start);
            SystemLogEntity log = new SystemLogEntity();
            log.setUId(user.getId());
            log.setUrl(request.getRequestURL().toString());
            log.setStartTime(start);
            log.setOptionName(request.getRequestURI());
            service.save(log);
            request.setAttribute("logId", log.getId());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getRequestURI().startsWith("/api")) {
            long start = (long) request.getAttribute("startTime");
            long end = System.currentTimeMillis();
            request.setAttribute("handleTime", end - start);
            request.setAttribute("endTime", end);
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getRequestURI().startsWith("/api")) {
            Number end = (Number) request.getAttribute("endTime");
            Number handleTime = (Number) request.getAttribute("handleTime");
            Number logId = (Number) request.getAttribute("logId");
            SystemLogEntity log = service.getById(logId.longValue());
            log.setEndTime(end.longValue());
            log.setCostTime(handleTime.longValue());
            service.updateById(log);
        }
    }

    @Autowired
    public void setService(ISystemLogService service) {
        this.service = service;
    }


}
