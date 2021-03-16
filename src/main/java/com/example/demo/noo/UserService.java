package com.example.demo.noo;

import noo.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IWordService
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/5/5 10:03
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public JsonObject getById(int id) {
        return userDao.getById(id);
    }

    public void batchAdd(List<Map<String, Object>> list) {
        userDao.insertAll(list);
    }
}
   