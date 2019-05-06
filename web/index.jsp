<%--
  Created by IntelliJ IDEA.
  User: Allure
  Date: 2019/4/29
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%
        Object username = request.getAttribute("username");

    %>
</head>
<body>
    <form action="demo" method="post">
        <input type="text">
        <input type="submit" value="提交">
    </form>

</body>
</html>
