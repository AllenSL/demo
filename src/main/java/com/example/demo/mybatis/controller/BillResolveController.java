package com.example.demo.mybatis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.base.util.ResultInfo;
import com.example.demo.base.util.ResultUtil;
import com.example.demo.mybatis.pojo.BillResolve;
import com.example.demo.mybatis.service.IBillResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基于mybatis-plus的DB操作
 */
@RestController
@RequestMapping("/billResolve")
public class BillResolveController {

    @Autowired
    private IBillResolveService iBillResolveService;

    @GetMapping("/{transNo}")
    public ResultInfo queryBillResolveBykey(@PathVariable("transNo") Long transNo){
        BillResolve billResolve = iBillResolveService.queryByPrimaryKey(transNo);
        iBillResolveService.list();
        return ResultUtil.success(billResolve);
    }

    @GetMapping("/page")
    public ResultInfo queryBillResolveByPage(Page page, String budgetLevel){
        return ResultUtil.success(iBillResolveService.getBillResolvePage(page,budgetLevel));
    }
}
