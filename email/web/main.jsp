<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Mail" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件收发平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<script src="js/jquery-3.0.0.min.js"></script>
	<script src="js/main.js"></script>
</head>
<body>
<%
	List<Mail> mails = (List)session.getAttribute("mails");
%>

	<div id="main">
		<%--隐藏域  如果value等于default时执行普通分页,如果value等于search--%>
		<input type="hidden" value="default" id="fyType">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="menu.jsp" %>
			<div id="error">${error}</div>
				<div><span style="font-size:24px; font-weight: bold;">查看邮件</span>
					<input class="searchinp" name="search" placeholder="可通过发送人、标题、内容搜索"/> <button id="searchBtn">搜索</button></div>
			<div class="content messageList" style="clear: both;">
				<form action="/mail?type=delAllReceive" method="post" onsubmit="return checkdelAll()">
				<div class="emaildo">全选 <input type="checkbox" id="all" onclick="checkAll()"> <button>标记为已读</button>  <button id="delAll">删除勾选</button></div>
				<ul>
					<c:if test="${not empty mails}">
						<c:forEach items="${mails}" var="mail" varStatus="status">
							<li class="unReaded"> <input type="checkbox" name="ck" value="${mail.id}"/>

								<a href="/mail?type=readMsg&mailId=${mail.id}" class="no_xhx">
								<b>&lt;
									<c:if test="${fn:length(mail.title) > 10}">
										${fn:escapeXml(fn:substring(mail.title, 0, 10))}...
									</c:if>
									<c:if test="${fn:length(mail.title) <= 10}">
										${fn:escapeXml(mail.title)}
									</c:if>
								&gt;</b>
								<p>
									<c:if test="${fn:length(mail.content) > 20}">
										${fn:escapeXml(fn:substring(mail.content, 0, 20))}......
									</c:if>
									<c:if test="${fn:length(mail.content) <= 20}">
										${fn:escapeXml(mail.content)}
									</c:if>
								</p></a>
								<em><a href="">回信</a></em> <em><a href="/mail?type=delReceive&id=${mail.id}" onclick="return del()">删除</a></em></li>
						</c:forEach>
					</c:if>
				</ul>
				<br>
<p style="text-align:right;">
	<b>[<b id="current_row">1</b>/
		<b id="max_row">${sessionScope.get("mailrownum")}</b>]</b> &nbsp; <a href="#" id="fontPage">上一页</a> &nbsp; <a href="#" id="nextPage">下一页</a> </p>
				</form>
			</div>
		</div>
	</div>
<!--邮件格式,放在这里备用
					<li class="unReaded"> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p> <em><a href="">回信</a></em> <em><a
							href="">删除</a></em></li>
					<li class="unReaded"> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p> <em><a href="">回信</a></em> <em><a
							href="">删除</a></em></li>
					<li class="unReaded"> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p> <em><a href="">回信</a></em> <em><a
							href="">删除</a></em></li>
					<li class="unReaded"> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p> <em><a href="">回信</a></em> <em><a
							href="">删除</a></em></li>
					<li class="unReaded"> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p> <em><a href="">回信</a></em> <em><a
							href="">删除</a></em></li>
-->
</body>
<script>
</script>
</html>
