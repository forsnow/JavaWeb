package com.xuesong.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/3/29
 */
@WebServlet("/request02")
public class request02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        System.out.println(request.getContextPath());
        System.out.println(request.getQueryString());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getProtocol());
        System.out.println(request.getRemoteAddr());
    }
}