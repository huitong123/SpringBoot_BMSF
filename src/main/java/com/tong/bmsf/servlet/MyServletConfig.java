package com.tong.bmsf.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;
import java.util.Collection;
import java.util.LinkedList;

@Configuration(proxyBeanMethods = true)
public class MyServletConfig {


    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my2");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();

        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);

        Collection<String> link = new LinkedList<>();

        link.add("/my");
        link.add("/my2");

        myFilterFilterRegistrationBean.setUrlPatterns(link);
        // 放到集合中

//        return new FilterRegistrationBean(myFilter,myServlet());
        // 将myServlet和myFilter进行绑定  我就拦截这一个Servlet程序了

        return myFilterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyListener myListener = new MyListener();

        return new ServletListenerRegistrationBean<>(myListener);
    }
}
