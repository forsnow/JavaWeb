package com.xuesong.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : Snow
 * @date : 2020/4/3
 */
public class proxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        /**
         * 三个参数：
         * 1.类加载器：真实对象.getClass().getClassLoader()
         * 2.接口数组：真实对象.getClass().getInterface()
         * 3.处理器：new InvocationHandler()
         */
        sellComputer proxy_lenovo = (sellComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法 代理对象调用的所用方法都会触发该方法执行
             * @param proxy  代理对象
             * @param method 代理对象调用的方法，被封装为对象
             * @param args 代理对象调用方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了")

                //1.增强参数
                if(method.getName().equals("sellComputer")){
                    double money = (double)args[0];
                    System.out.println("专车接送");
                    money = money * 0.8;
                    Object object = method.invoke(lenovo, money);
                    System.out.println("送货上门");
                    return object+"鼠标垫";
                }else {

                    //使用真实对象调用改方法
                    Object object = method.invoke(lenovo, args);
                    return object;
                }

            }
        });

        String s = proxy_lenovo.sellComputer(9000);
        System.out.println(s);
       // proxy_lenovo.showComputer();
    }
}

