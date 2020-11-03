package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.pojo.SeqInfo;

import java.util.List;

public interface SeqInfoMapper {
    int deleteByPrimaryKey(String seqName);

    int insert(SeqInfo record);

    int insertSelective(SeqInfo record);

    SeqInfo selectByPrimaryKey(String seqName);

    int updateByPrimaryKeySelective(SeqInfo record);

    int updateByPrimaryKey(SeqInfo record);

    List<SeqInfo> getAllData();
}