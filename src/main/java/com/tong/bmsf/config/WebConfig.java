package com.tong.bmsf.config;

import com.tong.bmsf.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 定制SpringMVC拦截器相关
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/images/**","/js/**","/css/**","/fonts/**");

        // /** 除了动态请求会拦截  静态资源也会拦截
        // 解决
        // 1. 在excludePathPatterns中加上  /css/** /js/** .... 这种
        // 2. 修改静态资源路径, 但是页面多的话改路径可能会很麻烦  static/xxxx

    }
}
