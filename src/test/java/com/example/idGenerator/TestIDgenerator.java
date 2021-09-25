package com.example.idGenerator;

import com.example.base.AbstractBaseTest;
import com.gome.architect.idgnrt.IDGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestIDgenerator extends AbstractBaseTest {


    @Autowired
    IDGenerator idGenerator;

    @Test
    public void testIDgenerator(){

        for (int i = 0; i < 400; i++) {
            long next = idGenerator.next();
            System.out.println(next);
        }
    }
}
