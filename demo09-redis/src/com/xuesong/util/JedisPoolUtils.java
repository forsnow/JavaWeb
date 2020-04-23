package com.xuesong.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : Snow
 * @date : 2020/4/22
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        //创建Properties对象
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //初始化JedisPool
        int port = Integer.parseInt(properties.getProperty("port"));
        jedisPool = new JedisPool(config,properties.getProperty("host"),port);
    }

    //获取连接方法
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    //关闭方法
    public static void Close(Jedis jedis){
        jedis.close();
    }
}
