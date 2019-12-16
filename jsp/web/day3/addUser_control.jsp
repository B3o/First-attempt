<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/5
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("un");
    String password = request.getParameter("pw");
    String birthday = request.getParameter("birthday");
    String sex = request.getParameter("sex");
    String age = request.getParameter("age");
    boolean flag = false;
    if (age == null || "".equals(age)) {
        age = "1";
        flag = true;
    }
    UserDao ud = new UserDao();
    int result = ud.addUser(username, password, birthday, sex, Integer.valueOf(age));
    if (result < 0 || flag) {
        out.print("<script>alert('添加用户失败,请检查')</script>");
        response.sendRedirect("addUser.jsp");
    } else {
        out.print("<script>alert('添加用户成功!')</script>");
        request.setAttribute("temp", "add_success");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
%>
</body>
</html>
