package com.wjh.wiki.service;

import com.wjh.wiki.domain.Ebook;
import com.wjh.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(){

        return ebookMapper.selectByExample(null);
    }
}
