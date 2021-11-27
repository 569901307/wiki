package com.wjh.wiki.mapper;

import com.wjh.wiki.domain.Demo1;
import com.wjh.wiki.domain.Demo1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Demo1Mapper {
    long countByExample(Demo1Example example);

    int deleteByExample(Demo1Example example);

    int deleteByPrimaryKey(Long id);

    int insert(Demo1 record);

    int insertSelective(Demo1 record);

    List<Demo1> selectByExample(Demo1Example example);

    Demo1 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Demo1 record, @Param("example") Demo1Example example);

    int updateByExample(@Param("record") Demo1 record, @Param("example") Demo1Example example);

    int updateByPrimaryKeySelective(Demo1 record);

    int updateByPrimaryKey(Demo1 record);
}