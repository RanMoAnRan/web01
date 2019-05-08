package com.zongheanli.web;

import com.zongheanli.domain.ContactInfo;
import com.zongheanli.service.ContactService;
import com.zongheanli.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/add_contact")
public class AddContactServlet extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        ContactInfo contactInfo = new ContactInfo();
        try {
            BeanUtils.populate(contactInfo, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(contactInfo);
        contactService.insertContactInfo(contactInfo);
        response.sendRedirect(request.getContextPath()+"/query_contacts");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
