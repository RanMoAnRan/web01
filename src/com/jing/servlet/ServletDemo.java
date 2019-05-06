package com.jing.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//@WebServlet(name = "ServletDemo")
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post请求");
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getCookies());
        System.out.println(request.getRequestURL());
        System.out.println(request.getSession());

        System.out.println("--------------");
        System.out.println("User-Agent"+request.getHeader("User-Agent"));
        System.out.println("Accept"+request.getHeader("Accept"));
        System.out.println("---------------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name+":"+request.getHeader(name));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
