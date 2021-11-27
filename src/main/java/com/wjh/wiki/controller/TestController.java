package com.wjh.wiki.controller;

import com.wjh.wiki.domain.Demo;
import com.wjh.wiki.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {


    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private DemoService demoService;

    @GetMapping("/demo/list")
    public List<Demo> list(){
        return demoService.list();
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!"+testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "Hello world!Post"+name;
    }


}
