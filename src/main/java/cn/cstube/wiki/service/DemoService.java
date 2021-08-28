package cn.cstube.wiki.service;

import cn.cstube.wiki.domain.Demo;
import cn.cstube.wiki.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther heling
 * @date 2021/8/27
 */
@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

     public List<Demo> list(){
         return demoMapper.selectByExample(null);
     }
}
