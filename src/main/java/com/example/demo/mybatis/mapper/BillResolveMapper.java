package com.example.demo.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mybatis.pojo.BillResolve;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillResolveMapper extends BaseMapper<BillResolve> {

//    // 普通查询
//    BillResolve getUserByName(String userName );

    // 分页查询
    IPage<List<BillResolve>> getUsersPage(Page page, @Param("budgetLevel") String budgetLevel );
}