package com.example.demo.mybatis.controller;

import com.example.demo.base.page.Page;
import com.example.demo.base.page.PageDTO;
import com.example.demo.base.util.ResultInfo;
import com.example.demo.base.util.ResultUtil;
import com.example.demo.mybatis.pojo.SeqInfo;
import com.example.demo.mybatis.service.ISeqInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

/**
 * 基于mybatis的DB操作
 */
@RestController
@RequestMapping("/seqInfo")
public class SeqInfoController {

    //    @Autowired
    private ISeqInfoService iSeqInfoService;

    @GetMapping("/{seqName}")
    public ResultInfo querySeqInfoBykey(@PathVariable("seqName") String seqName) {
        SeqInfo seqInfo = iSeqInfoService.queryInfoBySeqName(seqName);
        return ResultUtil.success(seqInfo);
    }

    @PostMapping("/getPageData")
    public ResultInfo queryAllDataByPage(@RequestBody Page page) {
        PageInfo<SeqInfo> seqInfoPageInfo = iSeqInfoService.queryDataByPage(page);
        PageDTO<SeqInfo> pageDTO = new PageDTO<SeqInfo>(seqInfoPageInfo.getList(), seqInfoPageInfo.getTotal());
        return ResultUtil.success(pageDTO);
    }

}
