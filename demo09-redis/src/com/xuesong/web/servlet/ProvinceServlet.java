package com.xuesong.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuesong.domain.Province;
import com.xuesong.service.ProvinceService;
import com.xuesong.service.imp.ProvinceServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : Snow
 * @date : 2020/4/23
 */
@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.调用service查询
//        ProvinceService service = new ProvinceServiceImp();
//        List<Province> list = service.findAll();
//
//        //2.序列化list为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
//        System.out.println(json);

        //用redis缓存
        ProvinceService service = new ProvinceServiceImp();
        String json = service.findAllJson();
        System.out.println(json);

        //3.响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
