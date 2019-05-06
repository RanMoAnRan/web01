package com.jing.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

@WebServlet("/session_demo")
public class SessionDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        out.write(session.getId());
        out.write("<br/>");
        out.write(session.getMaxInactiveInterval());
        out.write("<br/>");
        out.write(String.valueOf(session.isNew()));
        out.write("<br/>");
        out.write(new SimpleDateFormat("yyyy-MM-dd").format(session.getCreationTime()) );
        out.write("<br/>");
        out.write(new SimpleDateFormat("yyyy-MM-dd").format(session.getLastAccessedTime()));
        out.write("<br/>");
        out.write(String.valueOf(session.getServletContext()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
