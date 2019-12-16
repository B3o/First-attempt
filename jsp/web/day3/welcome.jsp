<%@ page import="dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/5
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.0.0.min.js"></script>
</head>
<body>
<%@include file="checkLogin.jsp"%>
<%
    String username = request.getParameter("un");
    String temp = (String)request.getAttribute("temp");
    if ("add_success".equals(temp)) {
        out.print("<h1>恭喜你,注册成功!</h1>");
    } else if ("del_success".equals(temp)) {
        out.print("<h1>用户删除成功</h1>");
    } else {
        out.print("<h1>欢迎你:" + username + ", 登陆成功</h1>");
    }

%>


<h1>展示用户列表</h1>
<a href="addUser.jsp">新增用户</a>
<table border="1px">
    <tr>
        <%--th是带加粗居中的,td没有--%>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>生日</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <%
        UserDao ud = new UserDao();
        List<User> users = ud.queryAll();
    %>
    <% for (User u : users) {%>
    <tr>
        <td><%=u.getId()%></td>
        <td><a href="user_update.jsp?id=<%=u.getId()%>"><%=u.getUsername()%></a></td>
        <td><%=u.getPassword()%></td>
        <td><%=u.getBirthday()%></td>
        <td><%=u.getSex()%></td>
        <%--性别用三目--%>
        <td><%=u.getAge()%></td>
        <td><a href="delUser_control.jsp?id=<%=u.getId()%>" onclick="return confirmd()">删除</a></td>
    </tr>
    <%}%>
    <%--
        UserDao ud = new UserDao();
        List<User> users = ud.queryAll();
        for (User user : users) {
            out.print("<tr>");
            out.print("<td><a href=\"#\">"  + user.getId() + "</a></td>");
            out.print("<td>" + user.getUsername() + "</td>");
            out.print("<td>" + user.getPassword() + "</td>");
            out.print("<td>" + user.getBirthday() + "</td>");
            out.print("<td>" + user.getSex() + "</td>");
            out.print("<td>" + user.getAge() + "</td>");
            out.print("<td><a href=#>删除</a></td>");
            out.print("</tr>");
        }
    --%>
</table>
</body>
<script>
    function confirmd() {
        if (confirm("确定要删除该用户吗?")) {
            return true;
        } else {
            return false;
        }
    }
    // $(function () {
    //     $("#jump").click(function () {
    //         if (confirm("确定要删除该用户吗?")) {
    //             alert("yes");
    //         } else {
    //             $("#test")[0].href = "www.adksld";
    //             $("#test")[0].click();
    //
    //         }
    //     })
    // });

</script>
</html>
