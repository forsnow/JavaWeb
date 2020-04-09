package com.xuesong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/3/30
 */
@WebServlet("/request04")
public class request04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useragent = request.getHeader("user-agent");
        if (useragent.contains("Chrome")){
            System.out.println("This is Chrome Browser");
        }else if(useragent.contains("Firefox")){
            System.out.println("This is Firefox Browser");
        }
    }
}
