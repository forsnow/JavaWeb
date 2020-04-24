package com.xuesong.service.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuesong.dao.ProvinceDao;
import com.xuesong.dao.imp.ProvinceDaoImp;
import com.xuesong.domain.Province;
import com.xuesong.service.ProvinceService;
import com.xuesong.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author : Snow
 * @date : 2020/4/23
 */
public class ProvinceServiceImp implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImp();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }


    /**
     * 数据库的表执行 增删改的相关操作，需要将redis缓存数据情况，再次存入
     * 在service对应的增删改方法中，将redis数据删除，
     *
     *
     */
    @Override
    public String findAllJson() {
        //获取jedis连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //判断是否存在
        if(province_json == null || province_json.length()==0){
            //redis 没有数据 缓存中没有数据
            System.out.println("redis 没有数据 缓存中没有数据,从数据库中查询...");
            //从数据库中查询
            List<Province> list = dao.findAll();
            //将list 序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //将json数据存入redis中
            jedis.set("province",province_json);
            //关闭jedis
            jedis.close();
        } else {
            System.out.println("redis有数据，查询缓存");
        }

        return province_json;
    }
}
