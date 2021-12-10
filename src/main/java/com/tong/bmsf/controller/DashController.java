package com.tong.bmsf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashController {

    @GetMapping("/dash_board")
    public String dash_board(){
        return "dash_board/board";
    }
}
