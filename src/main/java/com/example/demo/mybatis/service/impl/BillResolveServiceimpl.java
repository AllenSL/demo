package com.example.demo.mybatis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mybatis.mapper.BillResolveMapper;
import com.example.demo.mybatis.pojo.BillResolve;
import com.example.demo.mybatis.service.IBillResolveService;

import javax.annotation.PostConstruct;
import java.util.List;

//@Service
public class BillResolveServiceimpl extends ServiceImpl<BillResolveMapper, BillResolve> implements IBillResolveService {


    @PostConstruct
    public void init() {
        List<BillResolve> list = this.list();
    }

    @Override
    public BillResolve queryByPrimaryKey(Long transNo) {
        return baseMapper.selectById(transNo);
    }

    @Override
    public int insertBillResolve(BillResolve billResolve) {
        return 0;
    }

    @Override
    public int updateBillResolve(BillResolve billResolve) {
        return 0;
    }

    @Override
    public int deleteBillResolve(BillResolve billResolve) {
        return 0;
    }

    @Override
    public IPage getBillResolvePage(Page page, String budgetLevel) {
        return baseMapper.getUsersPage(page, budgetLevel);
    }

}
