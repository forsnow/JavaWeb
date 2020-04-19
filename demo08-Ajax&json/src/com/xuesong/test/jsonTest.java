package com.xuesong.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuesong.domain.Person;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author : Snow
 * @date : 2020/4/13
 */
public class jsonTest {
    @Test
    public void Test01(){
        Person person = new Person();
        person.setName("xuesong");
        person.setAge(24);
        person.setGendar("male");
        person.setBirthday(new Date());

        //创建
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(person);
            //objectMapper.writeValue(new File("D:\\1.txt"),person);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }

    @Test
    public void Test02(){
        Person person01 = new Person();
        person01.setName("jiangxuesong");
        person01.setAge(24);
        person01.setGendar("male");
        person01.setBirthday(new Date());

        Person person02 = new Person();
        person02.setName("xuesong");
        person02.setAge(24);
        person02.setGendar("male");
        person02.setBirthday(new Date());

        Person person03 = new Person();
        person03.setName("song");
        person03.setAge(24);
        person03.setGendar("male");
        person03.setBirthday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(person01);
        list.add(person02);
        list.add(person03);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(list);
            System.out.println(json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test03(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","xuesong");
        map.put("age",24);
        map.put("gender","male");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonMap = mapper.writeValueAsString(map);
            System.out.println(jsonMap);
            //{"gender":"male","name":"xuesong","age":24}
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
