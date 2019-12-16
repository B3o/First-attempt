<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件收发平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<script src="js/jquery-3.0.0.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<script src="js/bootstrap.js"></script>
	<link type="text/css" rel="stylesheet" href="css/index.css">
</head>
<body>
<div style="width:360px; margin:0px auto; margin-top: 60px; color:white;font-size:30px" class="png">云端科技邮件管理系统</div>
<div id="loginForm" class="userForm png">
	<form method="post" name="loginform" action="user?type=login" onsubmit = "return checkForm()">
		<dl>
			<dt>用户名：</dt>
			<dd><input type="text" name="username" /></dd>
			<dt>密　码：</dt>
			<dd><input type="password" name="password" /></dd>
		</dl>
		<div class="buttons">
			<input class="btn-login png" type="submit" name="submit" value=" " />
			<input class="btn-reg png" type="button" name="register" value=" " />
		</div>		
	</form>
	<div id="msg_info">
		<p class="bg-danger">${error}</p>
		<p class="bg-success">${successInfo}</p>
	</div>

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
        };
		$(function () {
			$("input[name = 'register']").click(function () {
				window.open("register.jsp", "_self");
            })
        })

</script>
</html>

