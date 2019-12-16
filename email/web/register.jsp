<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<script src="js/jquery-3.0.0.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/register.css" >
	<script src="js/bootstrap.js"></script>
</head>
<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">
	<br>
	<form action="/user?type=reg" onsubmit = "return checkForm()" method="post">
		<dl>
		    <div id="error"> ${error }</div>
			<dt>用 户 名：</dt>
			<dd><input type="text" name="username"/>
			</dd>
			<dt>密　　码：</dt>
			<dd><input type="password" name="password" /></dd>
			<dt>确认密码：</dt>
			<dd><input type="password" name="affirm" /></dd>
			<%--<dt>邮　　箱：</dt>--%>
			<%--<dd><input type="text" name="email" /></dd>--%>
		</dl>
		<div class="buttons">
			<input class="btn-reg png" type="submit" name="register" value=" " />
			<input class="btn-reset png" type="reset" name="reset" value=" " />
		</div>
		<div id="msg_info">
			<p class="bg-danger" ></p>
		</div>
		<div class="goback"><a href="index.jsp" class="png">返回登录页</a></div>
	</form>

</div>
</body>
<script>
	function checkForm() {
        if ($("input[name = 'username']").val() == "" || $("input[name = 'username']").val() == null) {
            $(".bg-danger").html("账号名不能为空!");
            return false;
        }
        if ($("input[name = 'password']").val() == "" || $("input[name = 'password']").val() == null) {
            $(".bg-danger").html("密码不能为空!");
            return false;
        }
        if ($("input[name = 'affirm']").val() == "" || $("input[name = 'affirm']").val() == null) {
            $(".bg-danger").html("请再输入一遍密码!");
            return false;
        }
        if ($("input[name = 'password']").val() != $("input[name = 'affirm']").val()) {
            $(".bg-danger").html("两次输入的密码不一致!");
            return false;
        }
        return true;
    }

</script>
</html>
