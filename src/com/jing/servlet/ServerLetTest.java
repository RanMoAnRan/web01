package com.jing.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @ClassName:ServerLetTest
 * @Description TODO
 * @author:RanMoAnRan
 * @Date:2019/4/29 15:36
 * @Version 1.0
 */

@WebServlet("/hello")
public class ServerLetTest implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("被创建了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("请求成功");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
