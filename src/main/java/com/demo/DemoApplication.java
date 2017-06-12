package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@SpringBootApplication
public class DemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("成功启动Spring Boot应用 ！");
    }
    
    /**
     * 显示主页
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index(){
        System.out.println("进入主页！");
        return "/view/index.html";
    }
}
