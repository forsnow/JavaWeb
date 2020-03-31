package com.xuesong.web.servlet;

import com.xuesong.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/3/31
 */
@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取request域的共享数据
        User user = (User) request.getAttribute("user");

        if (user != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功" + user.getUsername() + "是个帅哥QAQ~");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
