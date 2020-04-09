package com.xuesong.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/4/1
 */
@WebServlet("/cookie03")
public class cookie03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie01 = new Cookie("name","xuseong");
        Cookie cookie02 = new Cookie("name","zhangsan");
        cookie01.setMaxAge(30);
        cookie02.setMaxAge(-1);
        response.addCookie(cookie01);
        response.addCookie(cookie02);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
