package com.example.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ansonglin
 * @className JedisPoolUtils
 * @description TODO
 * @date 2021/3/4 11:32 上午
 * @cersion 1.0
 **/
public class JedisPoolUtils {
    private static JedisPool pool = null;

    static {

        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10);//最大闲置个数
        poolConfig.setMaxWaitMillis(10);//最大闲置个数
        poolConfig.setMinIdle(2);//最小闲置个数
        poolConfig.setMaxTotal(1000);//最大连接数
        pool = new JedisPool(poolConfig, "47.92.81.14", 6379, 6000, "offcn_app");
    }

    //获得jedis资源的方法
    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        System.out.println(jedis);
    }
}
   