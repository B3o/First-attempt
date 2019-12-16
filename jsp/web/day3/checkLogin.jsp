<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/6
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User currentUser = (User) session.getAttribute("login_condition");
    if (currentUser == null) {
        response.sendRedirect("login.jsp");
    }
%>

</body>
</html>
