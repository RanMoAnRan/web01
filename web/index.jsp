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
    <title>首页</title>

    <link rel='stylesheet' href='bootstrap/css/bootstrap.css'/>
    <script src='bootstrap/js/jquery-1.9.1.js'></script>
    <script src='bootstrap/js/bootstrap.js'></script>
</head>

<body>
<div align="center">
    <a href="query_contacts" style="text-decoration:none;font-size:33px">查询所有用户信息</a>
</div>

<form action="add_to_cart" method="post">
    <input type="checkbox" name="goods" value="iphon">iphon<br>
    <input type="checkbox" name="goods" value="dianao">电脑<br>
    <input type="checkbox" name="goods" value="shouji">手机<br>
    <input type="checkbox" name="goods" value="摄像机">摄像机<br>
    <input type="submit" value="加入购物车">
</form>
</body>
</html>
