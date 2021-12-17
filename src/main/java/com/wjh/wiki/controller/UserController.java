package com.wjh.wiki.controller;

import com.wjh.wiki.req.UserQueryReq;
import com.wjh.wiki.req.UserSaveReq;
import com.wjh.wiki.resp.CommonResp;
import com.wjh.wiki.resp.UserQueryResp;
import com.wjh.wiki.resp.PageResp;
import com.wjh.wiki.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req){
        CommonResp<PageResp<UserQueryResp>> resp=new CommonResp<>();
        PageResp<UserQueryResp> list=userService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req){
        CommonResp resp=new CommonResp<>();
        userService.save(req);
        return resp;
    }


    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp=new CommonResp<>();
        userService.delete(id);
        return resp;
    }

    


}
