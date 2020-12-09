package com.ssmbook2020.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用纯文本方式
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.判断用户名和密码是否正确
        if ("newboy".equalsIgnoreCase(username) && "123".equals(password)) {
            //3.返回登录的结果，使用纯文本打印
            out.print("欢迎您：" + username + "，登录成功");
        } else {
            out.print("登录失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
