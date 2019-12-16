<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短消息平台</title>
	<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<link type="text/css" rel="stylesheet" href="css/register.css">
	<script src="js/jquery-3.0.0.min.js"></script>
</head>
<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">

	<form action="/email/user?type=reg" onsubmit = "return check()" method="post">
		<dl>
		    <div id="error"> ${error}</div>
			<dt>用 户 名：</dt>
			<dd><input type="text" name="username" /></dd>
			<dt>密　　码：</dt>
			<dd><input type="password" name="password" /></dd>
			<dt>确认密码：</dt>
			<dd><input type="password" name="affirm" /></dd>
			<dt>邮　　箱：</dt>
			<dd><input type="text" name="email" /></dd>
		</dl>
		<div class="buttons">
			<input class="btn-reg png" type="submit" name="register" value=" " /><input class="btn-reset png" type="reset" name="reset" value=" " />
		</div>
		<div class="goback"><a href="index.jsp" class="png">返回登录页</a></div>
	</form>
</div>
</body>
<script>
    function check() {
        var un = $("input[name = 'username']").val();
        var pw = $("input[name = 'password']").val();
        var pw2 = $("input[name = 'affirm']").val();
        var em = $("input[name = 'email']").val();
        if (un == null || un == "") {
            $("#error").html("用户名输入有误");
            return false;
		}
		if (pw == null || pw == "" || pw2 == null || pw2 == ""){
            $("#error").html("密码输入有误");
            return false;
		}
        if (pw != pw2){
            $("#error").html("两次密码不一致");
            return false;
        }
        if (em == null || em == "" || em.indexOf("@") == -1) {
            $("#error").html("邮件输入有误");
            return false;
		}
        return true;
    }
</script>
</html>
