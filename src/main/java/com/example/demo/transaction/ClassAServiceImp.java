package com.example.demo.transaction;

import com.example.demo.transaction.service.ClassAService;
import com.example.demo.transaction.service.ClassBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *@className ClassAServiceImp
 *@description TODO
 *@author ansonglin
 *@date 2021/2/22 9:27 上午
 *@cersion 1.0
 **/
@Service
public class ClassAServiceImp implements ClassAService {

    @Autowired
    ClassBService classBService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testA() {
      classBService.testB();
      jdbcTemplate.execute("insert into test(id,age) value(1,2)");
    }
}
   