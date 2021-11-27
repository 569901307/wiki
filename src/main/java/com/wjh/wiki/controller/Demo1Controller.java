package com.wjh.wiki.controller;

import com.wjh.wiki.domain.Demo1;
import com.wjh.wiki.service.Demo1Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo1")
public class Demo1Controller {
    
    @Resource
    private Demo1Service demo1Service;

    @GetMapping("/list")
    public List<Demo1> list(){
        return demo1Service.list();
    }

    


}
