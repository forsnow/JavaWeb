package com.xuesong.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Snow
 * @date : 2020/4/2
 */
@WebServlet("/cookieTest")
public class cookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {

                String name = c.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String valueTemp = simpleDateFormat.format(date);

                    System.out.println("编码前" + valueTemp);
                    valueTemp = URLEncoder.encode(valueTemp, "utf-8");
                    System.out.println("编码后" + valueTemp);

                    c.setValue(valueTemp);
                    c.setMaxAge(60 * 60 * 24 * 31);
                    response.addCookie(c);

                    String value = c.getValue();

                    System.out.println("解码前"+value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后"+value);

                    response.getWriter().write("<h1>欢迎回来 您上次登录的时间为:" + value + "</h1>");
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = simpleDateFormat.format(date);
            strDate = URLEncoder.encode(strDate,"utf-8");
            Cookie cookieTime = new Cookie("lastTime", strDate);
            cookieTime.setValue(strDate);
            cookieTime.setMaxAge(60 * 60 * 24 * 31);
            response.addCookie(cookieTime);
            response.getWriter().write("<h1>欢迎您 首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
