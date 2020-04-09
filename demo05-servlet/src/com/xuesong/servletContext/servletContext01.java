package com.xuesong.servletContext;

import javax.servlet.ServletContext;
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
@WebServlet("/servletContext01")
public class servletContext01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext1 = this.getServletContext();
        ServletContext servletContext2 = request.getServletContext();
        System.out.println(servletContext1);
        System.out.println(servletContext2);
        System.out.println(servletContext2==servletContext1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
