package cn.cstube.wiki.service;

import cn.cstube.wiki.domain.Ebook;
import cn.cstube.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther heling
 * @date 2021/8/27
 */
@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

     public List<Ebook> list(){
         return ebookMapper.selectByExample(null);
     }
}
