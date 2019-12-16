<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/16
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎登陆</h1>
<form action="${prefix}/login" method="post" enctype="multipart/form-data">
    <p>用户:</p> <input type="text" name="username">
    <p>密码: </p><input type="password" name="password">
    <p><input type="submit" value="登录"></p>
</form>

</body>
</html>
