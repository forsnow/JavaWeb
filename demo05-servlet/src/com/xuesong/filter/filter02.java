package com.xuesong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/4/2
 */
//@WebFilter("/*")
public class filter02 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter02");
        //放行
        chain.doFilter(req, resp);
        System.out.println("filter02 is back");

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
