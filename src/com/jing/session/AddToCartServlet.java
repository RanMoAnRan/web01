package com.jing.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        List<String> goods = (List<String>) session.getAttribute("goods");

        if (goods == null) {
            goods = new ArrayList<>();
            session.setAttribute("goods", goods);
        }

        String[] goods1 = request.getParameterValues("goods");
        goods.addAll(Arrays.asList(goods1));

        out.write("<h1>以成功加入购物车</h1>");

        response.sendRedirect(request.getContextPath() + "/balance");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
