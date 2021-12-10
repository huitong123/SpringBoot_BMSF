package com.tong.bmsf.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.tong.bmsf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @ResponseBody
    @GetMapping("/sql")
    public String getCount(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_emp", long.class);

        return aLong.toString();
    }

    @GetMapping(value={"/","/login"})
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login")
    public String index(User user, HttpSession session,Model model){


        if(!StringUtils.isEmpty(user.getUserName()) && StringUtils.hasLength(user.getPassWord())){
            session.setAttribute("USER_SESSION",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码不能为空!");
            return "login";
        }
    }
    /*
    * 这里的处理是为了解决登录后刷新时表单重复提交的情况 使用重定向来解决
    * */

    @GetMapping("/main.html")
    public String mainPath(HttpSession session,Model model){

//        Object user_session = session.getAttribute("USER_SESSION");
//        if(user_session != null){
//            // 登录成功
//            return "main";
//        }else{
//            model.addAttribute("msg","用户名或密码错误!");
//            return "login";
//        }
        return "main";
    }
}
