package com.xuesong.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : Snow
 * @date : 2020/4/22
 */
public class JedisTest01 {
    @Test
    public void Test01(){
        //String
        //获取连接
        Jedis jedis = new Jedis("0.0.0.0",6379);
        //操作
        jedis.set("ideakey","test");
        jedis.set("username","xuesong");
        String username = jedis.get("username");
        System.out.println(username);

        //设置过期时间
        //jedis.setex("activecode",10,"123456");


        //关闭连接
        jedis.close();
    }

    @Test
    public void Test02(){
        //map
        Jedis jedis = new Jedis("0.0.0.0",6379);
        jedis.hset("maptest","name","xuesong");
        jedis.hset("maptest","age","24");
        jedis.hset("maptest","gender","male");

//        String name = jedis.hget("maptest", "name");
//        System.out.println("name"+name);
//
//        String age = jedis.hget("maptest", "age");
//        System.out.println("age"+age);
//
//        String gender = jedis.hget("maptest", "gender");
//        System.out.println("gender"+gender);

        Map<String, String> maptest = jedis.hgetAll("maptest");
        Set<String> keySet = maptest.keySet();
        for (String key : keySet){
            String value = maptest.get(key);
            System.out.println(key+value);

        }

        jedis.close();
    }

    @Test
    public void Test03(){
        //list
        Jedis jedis = new Jedis();
        //jedis.lpush("mylist","a,b,c,d");
        //jedis.rpush("mylist","e,f,g,h,i");
        //List<String> mylist = jedis.lrange("mylist", 0, -1);
        //System.out.println(mylist);

        String element1 = jedis.lpop("mylist");
        System.out.println(element1);
        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        jedis.close();

    }

    @Test
    public void Test04(){
        //set
        Jedis jedis = new Jedis();
        jedis.sadd("books","java","c++","docker","shell","css");
        Set<String> books = jedis.smembers("books");
        System.out.println(books);
        jedis.close();

    }
}
