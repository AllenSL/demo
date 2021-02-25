package com.example.demo.transaction;

import com.example.demo.base.util.ResultInfo;
import com.example.demo.base.util.ResultUtil;
import com.example.demo.transaction.service.ClassAService;
import com.example.demo.transaction.service.ClassBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@className TWS
 *@description TODO
 *@author ansonglin
 *@date 2021/2/22 9:24 上午
 *@cersion 1.0
 **/
@RestController
@RequestMapping
public class TWS {

    @Autowired
    ClassAService classAService;
    @Autowired
    ClassBService classBService;

    @GetMapping("/transactionTest")
    public ResultInfo transactionTest(){
     classAService.testA();
     return ResultUtil.success();
    }

}
   