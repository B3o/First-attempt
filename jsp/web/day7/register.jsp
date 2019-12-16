<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/16
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.0.0.min.js" type="text/javascript"></script>
</head>
<body>
<form action="${prefix}/register" method="post" enctype="multipart/form-data">
    <div id="mess"></div>
    <p>用户: <input type="text" name="username"></p>
    <p>密码: <input type="password" name="password"></p>
    <p>上传头像: <input type="file" name="myFile"></p>
    <p><input type="submit" value="注册"></p>

</form>

</body>
<script>
    $("input[type='text']").blur(function () {
        $.ajax({
            url:"",
            type:"GET",

        })
    })
</script>
</html>
