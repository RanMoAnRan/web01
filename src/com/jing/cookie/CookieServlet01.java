package com.jing.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/cookie")
public class CookieServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf8");
        Cookie cookie = new Cookie("name", URLEncoder.encode("靖哥", "utf-8"));

        response.addCookie(cookie);

        PrintWriter writer = response.getWriter();
        writer.write(cookie.getName() + "<br/>");
        writer.write(URLDecoder.decode(cookie.getValue(), "utf-8") + "<br/>");

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie1 : cookies) {
            writer.write(cookie1.getName() + ":" + URLDecoder.decode(cookie1.getValue(), "utf-8") + "<br/>");
            cookie1.setMaxAge(0);
            response.addCookie(cookie1);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
