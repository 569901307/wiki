package com.wjh.wiki.controller;

import com.wjh.wiki.domain.Demo;
import com.wjh.wiki.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);


    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private RedisTemplate redisTemplate;

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


    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key);
        LOG.info("key: {}, value: {}", key, object);
        return object;
    }


}
