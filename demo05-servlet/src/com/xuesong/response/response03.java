package com.xuesong.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Snow
 * @date : 2020/4/1
 */
@WebServlet("/response03")
public class response03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取字符输出流之前设置流的编码格式
//        response.setCharacterEncoding("utf-8");
        //告诉浏览器以什么格式读取
        //response.setHeader("content-type","text/html;charset=utf-8");

        //简单形式设置编码
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter pw = response.getWriter();
        //
        pw.write("<h1>hello response~</h1>");
        pw.write("你好 世界 response test");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
