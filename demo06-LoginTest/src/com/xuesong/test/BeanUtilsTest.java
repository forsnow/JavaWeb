package com.xuesong.test;

import com.xuesong.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : Snow
 * @date : 2020/3/31
 */
public class BeanUtilsTest {
    @Test
    public void test(){
        Student student = new Student();
        try {
            BeanUtils.setProperty(student,"name","xuesong");
            String name = BeanUtils.getProperty(student, "name");
            System.out.println(name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(student);

    }
}
