<%@ page import="dao.UserDao" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/5
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改用户功能</h1>
<%
    String id = request.getParameter("id");
    UserDao ud = new UserDao();
    User u = ud.queryById(id);
%>
<form action="update_control.jsp" method="post">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <p>用户: <input type="text" name="un" value="<%=u.getUsername()%>"></p>
    <p>密码: <input type="password" name="pw" value="<%=u.getPassword()%>"></p>
    <p>生日: <input type="date" name="birthday" value="<%=u.getBirthday()%>"></p>
    <p>性别:
        <input type="radio" name="sex" value="1" <% if (u.getSex().equals("男")){%> checked <%}%> > 男
        <input type="radio" name="sex" value="0" <% if (u.getSex().equals("女")){%> checked <%}%> > 女
    </p>
    <p>年龄: <input type="text" name="age" value="<%=u.getAge()%>"></p>
    <p><input type="submit" value="确认修改"></p>
</form>

</body>
</html>
