package cn.cstube.wiki.service;

import cn.cstube.wiki.domain.Test;
import cn.cstube.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther heling
 * @date 2021/8/27
 */
@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

     public List<Test> list(){
         return testMapper.list();
     }
}
