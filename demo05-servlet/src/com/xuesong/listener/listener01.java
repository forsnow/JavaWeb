package com.xuesong.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author : Snow
 * @date : 2020/4/3
 */
@WebListener
public class listener01 implements ServletContextListener {
    /**
     * 监听ServletContext对象创建的  ServletConetext对象服务器启动后自动创建
     * 在服务器启动后自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了..");
    }

    /**
     * 当服务器正常关闭后，该方法被执行调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了..");
    }
}
