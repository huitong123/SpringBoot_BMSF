package com.tong.bmsf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormController {


    // 页面跳转
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }


    /*
    * multipartFile 用来封装上传的文件
    * */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email, @RequestParam("uname") String uname,
                         @RequestPart("headImg")MultipartFile multipartFile,@RequestPart("photos") MultipartFile[] multipartFiles){
        if(!multipartFile.isEmpty()){
            // 这里应该保存到文件服务器 由于自己做就不再演示
            // 保存到磁盘上
            String originalFilename = multipartFile.getOriginalFilename();
            // 原始的文件名
            try {
                multipartFile.transferTo(new File("D:"+ File.separator+originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(multipartFiles.length > 0){
            for (MultipartFile file : multipartFiles) {
                if(!file.isEmpty()){
                    String originalFilename = file.getOriginalFilename();
                    try {
                        file.transferTo(new File("D:"+File.separator+"Photo"+File.separator+originalFilename));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "main";
    }
}
