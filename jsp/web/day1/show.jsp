<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/3
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息展示页面</title>
</head>
<body>
    <h1>展示用户登陆:</h1>
    <%
        String username = request.getParameter("un");
        out.print(username);
    %>
</body>
</html>
