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
import java.util.List;

@WebServlet("/query_contacts")
public class QueryContactsServlet extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramCurrentPage = request.getParameter("currentPage");
        String paramPageSize = request.getParameter("pageSize");

        //当前页
        int currentPage = 1;
        //每页显示条数
        int pageSize = 5;

        if (paramCurrentPage != null) currentPage = Integer.parseInt(paramCurrentPage);
        if (paramPageSize != null) pageSize = Integer.parseInt(paramPageSize);


        //总条数
        int contactInfoSize = contactService.queryContactInfoSize();

        //System.out.println("总条数：" + contactInfoSize);
        //页数
        int pageCount = (int) Math.ceil(contactInfoSize / (double) pageSize);

       // System.out.println("页数：" + pageCount);
        //从第几条开始
        int pageOffset = (currentPage - 1) * pageSize;

        //List<ContactInfo> contactInfos = contactService.queryAll();
        List<ContactInfo> contactInfos = contactService.queryAll(pageOffset, pageSize);

        request.setAttribute("pageCount", pageCount);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("contacts", contactInfos);
        request.getRequestDispatcher("/zongheanli/list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
