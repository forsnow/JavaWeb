package com.xuesong.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author : Snow
 * @date : 2020/3/27
 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo02.class.getClassLoader().getResource("user.xml").getPath();
        Document doc = Jsoup.parse(new File(path), "utf-8");

        //获取所有user
        Elements user = doc.getElementsByTag("user");
        //System.out.println(user);

        //获取属性为id的
        Elements id = doc.getElementsByAttribute("id");
        //System.out.println(id);

        //获取属性id为2的
        Elements id2 = doc.getElementsByAttributeValue("id", "2");
        System.out.println(id2);

    }
}
