<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/4
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.0.0.min.js"></script>
</head>
<body>
<form action="" method="" onsubmit="return change()">
    <fieldset>
        <legend>注册</legend>
        <p>用户名: <input type="text" id="un"></p>
        <p>密码: <input type="password" id="pw"></p>
        <p>请再次输入密码: <input type="password" id="pw1"></p>
        <p><input type="submit" value="提交"></p>
        <div id="error" style="color: red;"></div>
    </fieldset>
</form>

</body>
<script>
    function change() {
        var username = $("#un").val();
        var pw = $("#pw").val();
        var pw1 = $("#pw1").val();
        if (username == null || username == "") {
            $("#error").html("账号名不能为null")
            return false;
        }
        if (pw == null || pw == "" || pw1 == null || pw1 == "") {
            $("#error").html("密码不能为null");
            return false;
        }
        if (pw != pw1) {
            $("#error").html("两次密码需要一致");
            return false;
        }
        return true;
    }
</script>
</html>
