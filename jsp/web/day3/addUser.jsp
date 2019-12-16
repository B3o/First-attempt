<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/5
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.0.0.min.js"></script>
</head>
<body>
<h1>用户信息添加:</h1>
<form action="addUser_control.jsp" method="post" onsubmit="return change()">
    <p>用户名:<input type="text" name="un"></p>
    <p>密码:<input type="password" name="pw"></p>
    <p>生日:<input type="date" name="birthday"></p>
    <p>性别:
        <input type="radio" name="sex" value="1" checked>男
        <input type="radio" name="sex" value="0">女
    </p>
    <p>年龄:<input type="text" name="age"></p>
    <p><input type="submit" value="新增用户" id="sub_btn" onsubmit="change()"></p>
    <p style="color: red;" id="errorMsg"></p>
</form>
</body>
<script>
    function change() {
        if ($("input[name = 'un']").val() == "" || $("input[name = 'un']").val() == null) {
            $("#errorMsg").html("账号名不能为空");
            return false;
        }
        if ($("input[name = 'pw']").val() == "" || $("input[name = 'pw']").val() == null) {
            $("#errorMsg").html("密码不能为空");
            return false;
        }
        if ($("input[name = 'birthday']").val() == "" || $("input[name = 'birthday']").val() == null) {
            $("#errorMsg").html("生日不能为空");
            return false;
        }
        if ($("input[name = 'age']").val() == "" || $("input[name = 'age']").val() == null) {
            $("#errorMsg").html("年龄不能为空");
            return false;
        }
        if ($("input[name = 'age']").val() < 1 || $("input[name = 'age']").val() > 100) {
            $("#errorMsg").html("年龄不合理");
            return false;
        }
        return true;
    }


</script>
</html>
