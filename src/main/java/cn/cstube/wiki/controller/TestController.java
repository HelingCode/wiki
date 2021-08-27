package cn.cstube.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther heling
 * @date 2021/8/27
 */
@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String testHello;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!" + testHello;
    }

    @PostMapping("hello/post")
    public String helloPost(String name){
        return "Hello World! Post, " + name;
    }
}
