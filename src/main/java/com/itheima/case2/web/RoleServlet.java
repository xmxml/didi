package com.itheima.case2.web;

import com.alibaba.fastjson.JSON;
import com.itheima.case2.pojo.po.Role;
import com.itheima.case2.service.Roleservice;
import com.itheima.case2.utils.BaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/role/*")
public class RoleServlet extends Base13Servlet {
    /**
     * @param request  : 请求信息对象,封装了浏览器携带给服务器的所有请求数据
     * @param response : 响应信息对象,封装了服务器返回给浏览器的所有数据
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        Roleservice roleservice = new Roleservice();
        List<Role> all = roleservice.findAll();
        String s = JSON.toJSONString(all);
        System.out.println(s);
        resp.getWriter().print(s);
        BaseController.printResult(resp,s);
    }


    /**
     * @param request  : 请求信息对象,封装了浏览器携带给服务器的所有请求数据
     * @param response : 响应信息对象,封装了服务器返回给浏览器的所有数据
     * @throws ServletException
     * @throws IOException
     */


}
