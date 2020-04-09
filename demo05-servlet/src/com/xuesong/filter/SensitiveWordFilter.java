package com.xuesong.filter;

import com.sun.deploy.net.HttpRequest;
import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * 敏感词汇过滤器
 * @author : Snow
 * @date : 2020/4/3
 */


@WebFilter("/*")
public class SensitiveWordFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象 增强getParameter()方法
        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter()方法
                if (method.getName().equals("getParameter")){
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null){
                        for (String str : arrayList){
                            if (value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }

                return method.invoke(req,args);
            }
        });


        //放行
        chain.doFilter(proxy_req, resp);
    }

    private ArrayList<String> arrayList = new ArrayList<String>();//敏感词汇的list集合
    public void init(FilterConfig config) throws ServletException {
        try {
            //加载文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/SensitiveWords.txt");
            //读取文件
            InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            //将文件的每一行数据添加到list中
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                arrayList.add(line);
            }
            System.out.println(arrayList);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }

}
