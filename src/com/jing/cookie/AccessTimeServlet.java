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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/access_time")
public class AccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String visitTime = getCookie(request, "visitTime");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String nowtime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());

        out.write("<h1>现在的时间是" + nowtime + "</h1>");
        if (visitTime != null) {
            out.println("<H1>您上次访问的时间是" + URLDecoder.decode(visitTime, "utf-8") + "</H1>");
        }

        response.addCookie(new Cookie("visitTime", URLEncoder.encode(nowtime, "utf-8")));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public String getCookie(HttpServletRequest request, String cookiename) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookiename)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
