package com.xuesong.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author : Snow
 * @date : 2020/3/27
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //获取Document对象。根据xml文档获取
        String path = JsoupDemo01.class.getClassLoader().getResource("user.xml").getPath();
        //解析xml文档，加载文档进内存，获取dom树
        Document document = Jsoup.parse(new File(path),"utf-8");
        //获取元素对象
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());

        //获取第一个name的elment对象
        Element element = name.get(0);
        //获取数据
        String text = element.text();
        System.out.println(text);

        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        Document parse = Jsoup.parse(url,10000);
        System.out.println(parse);


    }
}
