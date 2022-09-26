package com.itheima.case2.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class Base13Servlet extends HttpServlet {
    /**
     * @param request  : 请求信息对象,封装了浏览器携带给服务器的所有请求数据
     * @param response : 响应信息对象,封装了服务器返回给浏览器的所有数据
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ri = request.getRequestURI();
        int i = ri.lastIndexOf("/");
        String method = ri.substring(i + 1);
        Class a = this.getClass();
        try {
            Method method1 = a.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method1.invoke(this, request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param request  : 请求信息对象,封装了浏览器携带给服务器的所有请求数据
     * @param response : 响应信息对象,封装了服务器返回给浏览器的所有数据
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
