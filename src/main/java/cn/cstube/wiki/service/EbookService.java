package cn.cstube.wiki.service;

import cn.cstube.wiki.domain.Ebook;
import cn.cstube.wiki.domain.EbookExample;
import cn.cstube.wiki.mapper.EbookMapper;
import cn.cstube.wiki.req.EbookReq;
import cn.cstube.wiki.resp.EbookResp;
import cn.cstube.wiki.resp.PageResp;
import cn.cstube.wiki.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther heling
 * @date 2021/8/27
 */
@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

     public PageResp<EbookResp> list(EbookReq req){


         EbookExample ebookExample = new EbookExample();
         EbookExample.Criteria criteria = ebookExample.createCriteria();
          if(!ObjectUtils.isEmpty(req.getName())){
              criteria.andNameLike("%" + req.getName() + "%");
          }
         PageHelper.startPage(req.getPage(),req.getSize());
         List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

         PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
         LOG.info("总行数：{}", pageInfo.getTotal());
         LOG.info("总页数：{}", pageInfo.getPages());


//         List<EbookResp> respList = new ArrayList<>();
//         for (Ebook ebook : ebookList) {
//             //对象复制
//             respList.add(CopyUtil.copy(ebook,EbookResp.class));
//         }


         //列表复制
         List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

         PageResp<EbookResp> pageResp = new PageResp();
         pageResp.setTotal(pageInfo.getTotal());
         pageResp.setList(list);
         return pageResp;
     }
}
