package com.wjh.wiki.controller;

import com.wjh.wiki.req.DocQueryReq;
import com.wjh.wiki.req.DocSaveReq;
import com.wjh.wiki.resp.CommonResp;
import com.wjh.wiki.resp.DocQueryResp;
import com.wjh.wiki.resp.PageResp;
import com.wjh.wiki.service.DocService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {
    
    @Resource
    private DocService docService;

    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req){
        CommonResp<PageResp<DocQueryResp>> resp=new CommonResp<>();
        PageResp<DocQueryResp> list=docService.list(req);
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/all")
    public CommonResp all(){
        CommonResp<List<DocQueryResp>> resp=new CommonResp<>();
        List<DocQueryResp> list=docService.all();
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req){
        CommonResp resp=new CommonResp<>();
        docService.save(req);
        return resp;
    }


    @DeleteMapping("/delete/{idsStr}")
    public CommonResp delete(@PathVariable String idsStr){
        CommonResp resp=new CommonResp<>();
        List<String> list = Arrays.asList(idsStr.split(","));
        docService.delete(list);
        return resp;
    }

    


}
