package com.xuesong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/4/2
 */
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
public class filter03 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter03...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }

}
