package com.jing.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//脏词过滤
@WebFilter("/servlet_test")
public class FilterTest implements Filter {
    public void destroy() {
        System.out.println("filter被销毁了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String text=null;
        if (name.contains("傻")) {
            text=name.replace("傻","***");
        }

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("name",text);

        System.out.println(name);
        System.out.println(text);
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter被创建了");
    }

}
