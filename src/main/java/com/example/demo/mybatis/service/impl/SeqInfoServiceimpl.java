package com.example.demo.mybatis.service.impl;

import com.example.demo.base.page.Page;
import com.example.demo.mybatis.mapper.SeqInfoMapper;
import com.example.demo.mybatis.pojo.SeqInfo;
import com.example.demo.mybatis.service.ISeqInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeqInfoServiceimpl implements ISeqInfoService {

    @Autowired
    private SeqInfoMapper seqInfoMapper;

    @Override
    public SeqInfo queryInfoBySeqName(String seqName) {
        return seqInfoMapper.selectByPrimaryKey(seqName);
    }

    @Override
    public PageInfo<SeqInfo> queryDataByPage(Page page) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        List<SeqInfo> allData = seqInfoMapper.getAllData();
        return new PageInfo(allData);
    }
}
