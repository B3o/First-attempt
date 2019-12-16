<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/9
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("page", "pageOne");
    request.setAttribute("request", "request");
    session.setAttribute("session", "session");
    application.setAttribute("application", "application");
%>
<h1>page1:${pageScope.page}</h1>
<%
    pageContext.include("pageTwo.jsp");
%>
</body>
</html>
