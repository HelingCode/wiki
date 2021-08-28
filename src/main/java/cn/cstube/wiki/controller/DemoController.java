package cn.cstube.wiki.controller;

import cn.cstube.wiki.domain.Demo;
import cn.cstube.wiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther heling
 * @date 2021/8/27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;


    @GetMapping("/list")
    public List<Demo> list(){
        return demoService.list();
    }
}
