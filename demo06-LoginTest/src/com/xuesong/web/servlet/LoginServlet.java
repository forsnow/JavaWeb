package com.xuesong.web.servlet;

import com.xuesong.dao.UserDao;
import com.xuesong.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author : Snow
 * @date : 2020/3/31
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
//        //获取参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        //封装User对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        //获取所有请求参数
        Map<String, String[]> userMap = request.getParameterMap();
        //创建User对象
        User loginUser = new User();
        //使用BeanUtils将userMap封装为loginUser
        try {
            BeanUtils.populate(loginUser,userMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //调用UserDao的方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/failedServlet").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
