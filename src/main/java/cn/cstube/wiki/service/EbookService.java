package cn.cstube.wiki.service;

import cn.cstube.wiki.domain.Ebook;
import cn.cstube.wiki.domain.EbookExample;
import cn.cstube.wiki.mapper.EbookMapper;
import cn.cstube.wiki.req.EbookQueryReq;
import cn.cstube.wiki.req.EbookSaveReq;
import cn.cstube.wiki.resp.EbookQueryResp;
import cn.cstube.wiki.resp.PageResp;
import cn.cstube.wiki.util.CopyUtil;
import cn.cstube.wiki.util.SnowFlake;
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

    @Resource
    private SnowFlake snowFlake;

     public PageResp<EbookQueryResp> list(EbookQueryReq req){


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


//         List<EbookQueryResp> respList = new ArrayList<>();
//         for (Ebook ebook : ebookList) {
//             //对象复制
//             respList.add(CopyUtil.copy(ebook,EbookQueryResp.class));
//         }


         //列表复制
         List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);

         PageResp<EbookQueryResp> pageResp = new PageResp();
         pageResp.setTotal(pageInfo.getTotal());
         pageResp.setList(list);
         return pageResp;
     }

    /**
     * 保存
     */
    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }

    public void delete(Long id) {
        ebookMapper.deleteByPrimaryKey(id);

    }
}
