package com.xuesong.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author : Snow
 * @date : 2020/4/22
 */
public class JedisTest02 {
    @Test
    public void Test01(){
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);


        //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool();
        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        //3.使用
        jedis.hset("huageniubi","haha","123");
        jedis.hset("huageniubi","haha","456");
        jedis.hset("huageniubi2","haha","789");
        String hget = jedis.hget("huageniubi", "haha");
        String hget2 = jedis.hget("huageniubi2", "haha");
        System.out.println(hget);
        System.out.println(hget2);

        //关闭 归还给redis连接池
        jedis.close();


    }
}
