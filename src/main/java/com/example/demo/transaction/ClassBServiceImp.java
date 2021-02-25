package com.example.demo.transaction;

import com.example.demo.exception.BussinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.transaction.service.ClassBService;
import org.springframework.stereotype.Service;

/**
 *@className ClassBServiceImp
 *@description TODO
 *@author ansonglin
 *@date 2021/2/22 9:37 上午
 *@cersion 1.0
 **/
@Service
public class ClassBServiceImp implements ClassBService {


    @Override
//    @Transactional
    public void testB() {
     int a = 0;
     if(a == 0){
         throw new BussinessException(ErrorCode.ACCESSTOKEN_ERROE.getCode(),"msg");
     }
    }
}
   