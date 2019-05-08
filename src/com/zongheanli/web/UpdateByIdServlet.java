package com.zongheanli.web;

import com.zongheanli.domain.ContactInfo;
import com.zongheanli.service.ContactService;
import com.zongheanli.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_by_id")
public class UpdateByIdServlet extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContactInfo contact = contactService.queryById(id);
        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/zongheanli/update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
