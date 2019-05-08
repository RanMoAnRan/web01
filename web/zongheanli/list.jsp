<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<% String path = request.getContextPath(); %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户信息管理系统</title>

    <link rel='stylesheet' href='css/bootstrap.min.css'/>
    <script src='js/jquery-3.3.1.min.js'></script>
    <script src='js/bootstrap.min.js'></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function delById(contactId) {
            if (window.confirm("确认删除吗？")) {
                // location.href
                window.location = "del_by_id?id=" + contactId;
            }
        }

        //修改
        function updateById(contactId) {
            window.location = "update_by_id?id=" + contactId;
        }

        function changePageSize(pageSize) {
            window.location ="query_contacts?currentPage=1&pageSize=" + pageSize;
        }
    </script>

</head>

<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="zongheanli/add.jsp">添加联系人</a></td>
        </tr>
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${contacts}" var="contact" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${contact.name}</td>
                <td>${contact.gender == 'm' ? "男" : "女"}</td>
                <td>${contact.age}</td>
                <td>${contact.birthplace}</td>
                <td>${contact.mobile}</td>
                <td>${contact.email}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="javascript:void(0);" onclick="updateById(${contact.id})">修改</a>
                    <a class="btn btn-default btn-sm" href="javascript:void(0);" onclick="delById(${contact.id})">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8" align="center" class="form-inline">
                <c:forEach begin="1" end="${pageCount}" var="pageNum">
                    <a class="btn btn-default <c:if test="${pageNum == currentPage}">btn-success</c:if>"
                       href="query_contacts?currentPage=${pageNum}">${pageNum}</a>
                </c:forEach>
                <select class="form-control" onchange="changePageSize(this.value)">
                    <option value="0">-请选择-</option>
                    <option value="5">5条/页</option>
                    <option value="10">10条/页</option>
                    <option value="15">15条/页</option>
                </select>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
