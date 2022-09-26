package com.itheima.case2.web;

import com.alibaba.fastjson.JSON;
import com.itheima.case2.pojo.vo.PageResult;
import com.itheima.case2.pojo.vo.Result;
import com.itheima.case2.service.Userservice;
import com.itheima.case2.utils.BaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class User1Servlet extends Base13Servlet {
    /**
     * @param request  : 请求信息对象,封装了浏览器携带给服务器的所有请求数据
     * @param response : 响应信息对象,封装了服务器返回给浏览器的所有数据
     * @throws ServletException
     * @throws IOException
     */
    /*
    public void insert(HttpServletRequest request, HttpServletResponse response){
        System.out.println("增加用户");
    }
    public void update(HttpServletRequest request, HttpServletResponse response){
        System.out.println("修改用户");
    }
    public void delete(HttpServletRequest request, HttpServletResponse response){
        System.out.println("删除用户");
    }
    public void select(HttpServletRequest request, HttpServletResponse response){
        System.out.println("查询用户");
    }

     public  void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
         try{
             QueryPageBean queryPageBean = BaseController.parseJSON2Object(request, QueryPageBean.class);
             Userservice userservice = new Userservice();
             PageResult pageResult = userservice.selectByPage(queryPageBean);
             BaseController.printResult(response,new Result(true,"查询成功!",pageResult));
         }catch (Exception e){
             BaseController.printResult(response,new Result(false,"查询失败!"));

         }
     }

     */
    public void findByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        try{
            String parameter = req.getParameter("currentPage");
            String parameter1 = req.getParameter("pageSize");
            System.out.println(parameter);
            int i = Integer.parseInt(parameter);
            int i1 = Integer.parseInt(parameter1);
            Userservice userservice = new Userservice();
            PageResult allByPage = userservice.findAllByPage(i, i1);
            Result result = new Result(true, "成功", allByPage);
            BaseController.printResult(resp,result);
        }catch (Exception e){
            Result result = new Result(false,"失败",null);
            BaseController.printResult(resp,result);
            e.printStackTrace();
        }


    }




    /**
     * @param request  : 请求信息对象,封装了浏览器携带给服务器的所有请求数据
     * @param response : 响应信息对象,封装了服务器返回给浏览器的所有数据
     * @throws ServletException
     * @throws IOException
     */



}
