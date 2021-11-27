package com.wjh.wiki.service;

import com.wjh.wiki.domain.Demo1;
import com.wjh.wiki.mapper.Demo1Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Demo1Service {

    @Resource
    private Demo1Mapper demo1Mapper;

    public List<Demo1> list(){

        return demo1Mapper.selectByExample(null);
    }
}
