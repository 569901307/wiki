package com.wjh.wiki.controller;

import com.wjh.wiki.req.EbookQueryReq;
import com.wjh.wiki.req.EbookSaveReq;
import com.wjh.wiki.resp.CommonResp;
import com.wjh.wiki.resp.EbookQueryResp;
import com.wjh.wiki.resp.PageResp;
import com.wjh.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    
    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp=new CommonResp<>();
        PageResp<EbookQueryResp> list=ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req){
        CommonResp resp=new CommonResp<>();
        ebookService.save(req);
        return resp;
    }


    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp=new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }

    


}
