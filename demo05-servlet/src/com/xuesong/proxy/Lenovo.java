package com.xuesong.proxy;

/**
 * @author : Snow
 * @date : 2020/4/3
 */

//真实类
public class Lenovo implements sellComputer{
    @Override
    public void showComputer() {
        System.out.println("这个电脑8000元");
    }

    @Override
    public String sellComputer(double Money) {
        System.out.println("客户花了"+Money+"买了电脑");
        return "联想电脑";
    }
}
