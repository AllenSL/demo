package com.example.demo.mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mybatis.pojo.BillResolve;

public interface IBillResolveService extends IService<BillResolve> {

    BillResolve queryByPrimaryKey(Long transNo);

    int insertBillResolve(BillResolve billResolve);

    int updateBillResolve(BillResolve billResolve);

    int deleteBillResolve(BillResolve billResolve);

    IPage getBillResolvePage(Page page, String budgetLevel);
}
