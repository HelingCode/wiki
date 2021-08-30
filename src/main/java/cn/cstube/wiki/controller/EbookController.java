package cn.cstube.wiki.controller;

import cn.cstube.wiki.req.EbookQueryReq;
import cn.cstube.wiki.req.EbookSaveReq;
import cn.cstube.wiki.resp.CommonResp;
import cn.cstube.wiki.resp.EbookQueryResp;
import cn.cstube.wiki.resp.PageResp;
import cn.cstube.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public CommonResp list(@Valid EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp = new CommonResp();
        ebookService.delete(id);
        return resp;
    }
}
