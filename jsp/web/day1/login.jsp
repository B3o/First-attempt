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
    <title>Title</title>
</head>
<body>
<%--action = "数据提交到服务器的位置"
    method = "请求方式"
    get/post区别
    enctype = "传值方式" application/x-www-form-urlencoded 默认值 代表传递的值都是String
    multipart/form-data  代表传递的是附件形式--%>
<%--表单语义化 让表单的元素更有意义--%>
<form action="" method="">
    <fieldset style="width: 300px;">
        <legend>登陆</legend>
        <label for="un">用户: </label><input type="text" id = "un"><br>
        <label for="pw">密码: </label><input type="password" id = "pw">
        <input type="submit" value="登陆">
    </fieldset>
</form>

</body>
</html>
