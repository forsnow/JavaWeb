package com.xuesong.test;

import com.xuesong.util.JedisPoolUtils;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author : Snow
 * @date : 2020/4/23
 */
public class JedisTest03 {
    @Test
    public void TestJedisUtils(){
        Jedis jedis = JedisPoolUtils.getJedis();
        String username = jedis.get("username");
        System.out.println(username);
    }
}
