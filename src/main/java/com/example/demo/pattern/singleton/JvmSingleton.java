package com.example.demo.pattern.singleton;

/**
 * @ClassName JvmSingleton
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/5/10 11:44
 * @Version 1.0
 **/
public class JvmSingleton {

    private static class LazyHolder{
        public static final JvmSingleton JVM_SINGLETON = new JvmSingleton();
    }

    private JvmSingleton(){}

    public static JvmSingleton getInstance(){
        return LazyHolder.JVM_SINGLETON;
    }
}


   