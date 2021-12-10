package com.tong.bmsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//@ServletComponentScan(basePackages = "com.tong.bmsf")
// 扫描这个包下所有的Servlet
@SpringBootApplication
public class SpringBootBmsfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBmsfApplication.class, args);

        System.out.println("hello modify code!");
    }

}
