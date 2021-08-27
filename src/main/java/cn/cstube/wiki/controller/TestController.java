package cn.cstube.wiki.controller;

import cn.cstube.wiki.domain.Test;
import cn.cstube.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther heling
 * @date 2021/8/27
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

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

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
