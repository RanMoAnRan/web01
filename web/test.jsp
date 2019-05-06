<%@ page import="com.jsp.anli.services.UserServices" %>
<%@ page import="com.jing.servletanli.domain.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Allure
  Date: 2019/5/6
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!--添加视口-->
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <title></title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <script type="text/javascript" src="bootstrap/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
</head>
<body>

<table class="table table-bordered table-hover">

    <tr>
        <th class="active">编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>昵称</th>
        <th>年龄</th>
    </tr>

    <% UserServices userServices = new UserServices();%>
    <% List<User> users = userServices.getUser();%>

    <% for (User user : users) { %>

        <tr >
        <td><%=user.getId()%></td>
        <td><%=user.getusername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getnickname()%></td>
        <td><%=user.getAge()%></td>
    </tr>

  <%  }%>

</table>


</body>
</html>
