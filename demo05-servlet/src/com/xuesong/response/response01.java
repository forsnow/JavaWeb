package com.xuesong.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/4/1
 */

//重定向
@WebServlet("/response01")
public class response01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("response01...");
        //设置响应码
//        response.setStatus(302);
        //设置响应头
//        response.setHeader("location","/demo05/response02");

        //简单的重定向
//        response.sendRedirect("/demo05/response02");
        response.sendRedirect("https://qq.com");
        String contextPath = request.getContextPath();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
