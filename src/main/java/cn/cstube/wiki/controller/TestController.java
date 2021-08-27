package cn.cstube.wiki.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther heling
 * @date 2021/8/27
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
