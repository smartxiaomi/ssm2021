package com.ssmbook2020.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Servlet的访问地址
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的结果
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        //POST有汉字乱码的问题
        request.setCharacterEncoding("utf-8");
        //获取客户端提交的用户名参数
        String username = request.getParameter("username");
        //在服务器端打印出来
        System.out.println("请求的方式是：" + request.getMethod());
        System.out.println("用户名是：" + username);
        //判断用户是否存在
        if ("newboy".equalsIgnoreCase(username)) {
            out.print("用户已经存在");
        }
        else {
            out.print("恭喜可以注册");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
