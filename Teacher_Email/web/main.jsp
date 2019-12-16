<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件收发平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<script src="js/jquery-3.0.0.min.js"></script>
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="menu.jsp" %>
			<div id="error">${error}</div>


				<form action="/email/email">
					<div><span style="font-size:24px; font-weight: bold;">查看邮件</span>
					<input class="searchinp" name="search" placeholder="可通过发送人、标题、内容搜索"/> <button onclick="checkSearch()">搜索</button></div>
				</form>
			<div class="content messageList" style="clear: both;">
				<form action="/email/email?type=delAll" method="post">
				<div class="emaildo">全选 <input type="checkbox" id="all" onclick="checkAll()"> <button>标记为已读</button>  <button id="delAll">删除勾选</button></div>
				<ul>
					<c:forEach items="${toUserList}" var="e">
						<li class="unReaded"> <input type="checkbox" name="ck" value="${e.id}"/> <b>${e.title}</b>
							<p>${e.content}</p>
							<em><a href="">回信</a></em> <em>
								<a href="/email/email?type=del&id=${e.id}" onclick="return del()">删除</a></em>
						</li>
					</c:forEach>
				</ul>
				<br>
<p style="text-align:right;"> <b>[1/5]</b> &nbsp; <a href="">上一页<a> &nbsp; <a href="">下一页</a> </p>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	function del() {
	    return confirm("确定删除吗?");
	}
	function checkAll() {
	//    让其他复选框的选中状态   跟全选的选中状态一致
		var all = document.getElementById("all");
		var cks = document.getElementsByName("ck");
		for (var i = 0; i < cks.length; ++i) {
		    cks[i].checked = all.checked;
		}
    }
    $("#delAll").click(function () {
		document.getElementById("email").onsubmit;
    });
	function checkSearch() {
	    document.getElementById("search").onsubmit;
    }
</script>

</html>
