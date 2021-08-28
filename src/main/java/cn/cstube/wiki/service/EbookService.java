package cn.cstube.wiki.service;

import cn.cstube.wiki.domain.Ebook;
import cn.cstube.wiki.domain.EbookExample;
import cn.cstube.wiki.mapper.EbookMapper;
import cn.cstube.wiki.req.EbookReq;
import cn.cstube.wiki.resp.EbookResp;
import cn.cstube.wiki.util.CopyUtil;
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

     public List<EbookResp> list(EbookReq req){
         EbookExample ebookExample = new EbookExample();
         EbookExample.Criteria criteria = ebookExample.createCriteria();
         criteria.andNameLike("%" + req.getName() + "%");
         List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

//         List<EbookResp> respList = new ArrayList<>();
//         for (Ebook ebook : ebookList) {
//             //对象复制
//             respList.add(CopyUtil.copy(ebook,EbookResp.class));
//         }
         //列表复制
         List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
         return list;
     }
}
