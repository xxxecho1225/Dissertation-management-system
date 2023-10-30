package com.example.feignapi.util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public HandlerInterceptor getLoginInterceptorr(){
        return new LoginInterceptor();
    }

    /**
     * 添加Web项目的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截
        registry.addInterceptor(getLoginInterceptorr()).addPathPatterns("/**")
                .excludePathPatterns("/login_zhoukai","/no-auth_zhoukai", "/api/login","/api/login/**", "/css/**", "/images/**", "/js/**", "/fonts/**");
        //放行登录页，登陆操作，静态资源
    }
}
