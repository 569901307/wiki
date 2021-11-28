package com.wjh.wiki.service;

import com.wjh.wiki.domain.Ebook;
import com.wjh.wiki.domain.EbookExample;
import com.wjh.wiki.mapper.EbookMapper;
import com.wjh.wiki.req.EbookReq;
import com.wjh.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
           // ebookResp.setId(123L);   //测试用
            respList.add(ebookResp);
        }

        return respList;
    }
}
