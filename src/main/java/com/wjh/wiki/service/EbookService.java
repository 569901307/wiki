package com.wjh.wiki.service;

import com.wjh.wiki.domain.Ebook;
import com.wjh.wiki.domain.EbookExample;
import com.wjh.wiki.mapper.EbookMapper;
import com.wjh.wiki.req.EbookReq;
import com.wjh.wiki.resp.EbookResp;
import com.wjh.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

       /* List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {

            //EbookResp ebookResp = new EbookResp();
            //BeanUtils.copyProperties(ebook, ebookResp);
           //对象复制
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);

            respList.add(ebookResp);
        }*/

       //列表复制
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        return list;
    }
}