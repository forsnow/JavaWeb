package com.xuesong.test;

import com.xuesong.dao.UserDao;
import com.xuesong.domain.User;
import org.junit.jupiter.api.Test;

/**
 * @author : Snow
 * @date : 2020/3/31
 */
public class UserDaoTest {

    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("12121");
        loginUser.setPassword("ffff");
        UserDao userDao = new UserDao();

        User user = userDao.login(loginUser);
        System.out.println(user);

    }
}
