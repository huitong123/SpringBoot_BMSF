package com.tong.bmsf.Interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 做登录检查
*
*  1.配置好拦截器要拦截那些内容
*  2.把这些都放在容器中
* */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    // 前置代码
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle执行~");
        // 登录检查逻辑
        HttpSession session = request.getSession();
        // 拿到Session

        Object user_session = session.getAttribute("USER_SESSION");

        if(user_session!=null){
            // 放行
            return true;
        }// 拦截住 这里没有Session 跳转会login页面
        else{
            request.setAttribute("msg","用户未登录~");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }

    }

    // 后置代码
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行~");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 最后的代码
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行~");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
