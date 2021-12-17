package com.wjh.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjh.wiki.domain.User;
import com.wjh.wiki.domain.UserExample;
import com.wjh.wiki.mapper.UserMapper;
import com.wjh.wiki.req.UserQueryReq;
import com.wjh.wiki.req.UserSaveReq;
import com.wjh.wiki.resp.UserQueryResp;
import com.wjh.wiki.resp.PageResp;
import com.wjh.wiki.util.CopyUtil;
import com.wjh.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<UserQueryResp> list(UserQueryReq req){


        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getLoginName())) {
            criteria.andLoginNameEqualTo(req.getLoginName());
        }

        PageHelper.startPage(req.getPage(),req.getSize());
        List<User> userList = userMapper.selectByExample(userExample);

        PageInfo<User> pageInfo=new PageInfo<>(userList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

       /* List<UserResp> respList = new ArrayList<>();
        for (User user : userList) {

            //UserResp userResp = new UserResp();
            //BeanUtils.copyProperties(user, userResp);
           //对象复制
            UserResp userResp = CopyUtil.copy(user, UserResp.class);

            respList.add(userResp);
        }*/

       //列表复制
        List<UserQueryResp> list = CopyUtil.copyList(userList, UserQueryResp.class);

        PageResp<UserQueryResp> pageResp=new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }


    /*保存*/
    public void save(UserSaveReq req){
        User user=CopyUtil.copy(req,User.class);
        if (ObjectUtils.isEmpty(req.getId())){
            //新增
            user.setId(snowFlake.nextId());

            userMapper.insert(user);
        }else {
            //更新
            userMapper.updateByPrimaryKey(user);
        }

    }


    public void delete(Long id){
        userMapper.deleteByPrimaryKey(id);
    }
}
