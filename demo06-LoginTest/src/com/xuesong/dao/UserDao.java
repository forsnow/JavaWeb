package com.xuesong.dao;

/**
 * @author : Snow
 * @date : 2020/3/31
 */

import com.xuesong.domain.User;
import com.xuesong.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * dao   data access object  操作数据库的类
 */


public class UserDao {
    //声明JDBCTemplate对象共用
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
    * @Description: 
    * @Param: [loginUser]
    * @return: com.xuesong.login.User 没有查询到 返回null
    * @Author: Snow
    * @Date: 2020/3/31
    */
    public User login(User loginUser) {
        try {
            //编写sql
            String sql = "select * from user where username = ? and password = ?";
            //调用query方法
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
