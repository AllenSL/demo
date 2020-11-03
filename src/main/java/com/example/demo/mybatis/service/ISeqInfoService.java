package com.example.demo.mybatis.service;

import com.example.demo.base.page.Page;
import com.example.demo.mybatis.pojo.SeqInfo;
import com.github.pagehelper.PageInfo;

public interface ISeqInfoService {

   SeqInfo queryInfoBySeqName(String seqName);

   PageInfo<SeqInfo> queryDataByPage(Page page);

   default void defaultMethod(){
//      Collections.sort();
   };
}
