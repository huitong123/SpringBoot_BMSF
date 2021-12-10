package com.tong.bmsf.controller;


import com.tong.bmsf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(Model model){
        // 构造数据模拟表格遍历

        List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("zhangsan", "123456"),
                new User("zhangsan1", "123456"),
                new User("zhangsan2", "123456"),
                new User("zhangsan3", "123456"),
                new User("zhangsan4", "123456"),
                new User("zhangsan5", "123456"),
                new User("zhangsan6", "123456"));

        model.addAttribute("users",users);

        return "table/dynamic_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
