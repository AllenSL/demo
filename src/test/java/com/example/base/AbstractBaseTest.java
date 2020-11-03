package com.example.base;

import com.example.demo.DemoApplication;
import com.example.demo.noo.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @ClassName AbstractBaseTest
 * @Description 单元测试基类
 * @Autor ansonglin
 * @Date 2019/5/7 14:29
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AbstractBaseTest {
    public final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Test
    public void tt(){
        List<Map<String,Object>> list = new ArrayList<>();
     for (int i = 0;i <5;i ++){
         Map js = new HashMap();
         js.put("name",i+1);
         js.put("password",i+1);
         js.put("create_time",new Date());
         list.add(js);
        }
     userService.batchAdd(list);
    }

    public static void main(String[] args) {

    }
}
