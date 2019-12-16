<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/16
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登陆成功, 欢迎您:${u.username}-<img src="${prefix}/upload/${u.head}" alt="" style="width: 50px; height: 50px; "></h2>
<table border="1" cellspacing="0" cellpadding="10">
    <tr>
        <th>编号</th>
        <th>用户</th>
        <th>密码</th>
        <th>头像</th>
        <th>操作</th>
        <th>备注</th>
    </tr>
    <c:forEach var = "u" items="${list}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td><img src="${prefix}/upload/${u.head}" style="width: 50px; height: 50px; border-radius: 10px"></td>
            <td><a href="${prefix}/download?fileName=${u.head}">下载</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
