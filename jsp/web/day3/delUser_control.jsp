<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/5
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    UserDao ud = new UserDao();
    int result = ud.delUser(id);
    if (result > 0) {
        request.setAttribute("temp", "del_success");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    } else {
        response.sendRedirect("login.jsp");
    }
%>

</body>
</html>
