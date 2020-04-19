package com.xuesong.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Snow
 * @date : 2020/4/17
 */
@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        //期望服务器的回应响应数据是 {"userExit":true,"msg":"此用户名太受欢迎请换一个"}
        //                      {"userExit":false,"msg":"用户名可用"}
        Map<String,Object> map = new HashMap<>();
        if ("xuesong".equals(username)){
            map.put("userExit",true);
            map.put("msg","此用户名太受欢迎请换一个");
        }else {
            map.put("userExit",false);
            map.put("msg","用户名可用");
        }

        ObjectMapper mapper = new ObjectMapper();
        //将数据传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
