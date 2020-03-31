package com.xuesong.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author : Snow
 * @date : 2020/3/30
 */
@WebServlet("/request06")
public class request06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.getParameter(String name) 根据参数的名称获取参数的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+"---"+"password:"+password);

        //2.String[] getParameterValues(String name) 根据参数的名称返回参数值的数组
        String[] fruit = request.getParameterValues("Fruit");
        for (String s: fruit) {
            System.out.println(s);
        }

        //3.Enumeration<String> getParameterNames() 获取所有请求的参数名称
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String name = parameterNames.nextElement();
//            System.out.println(name);
////            String value = request.getParameter(name);
////            System.out.println(value);
////            System.out.println("-----");
//        }

        //4.Map<String,String[]> getParameterMap() 获取所有请求的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for(String name: keySet){
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for(String value:values){
                System.out.println(value);
            }
            System.out.println("----");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
