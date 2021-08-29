package cn.cstube.wiki.controller;

import cn.cstube.wiki.req.EbookReq;
import cn.cstube.wiki.resp.CommonResp;
import cn.cstube.wiki.resp.EbookResp;
import cn.cstube.wiki.resp.PageResp;
import cn.cstube.wiki.service.EbookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther heling
 * @date 2021/8/27
 */
@RestController
@RequestMapping("/ebook")
@CrossOrigin
public class EbookController {

    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(EbookReq req){
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
