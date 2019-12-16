<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Mail" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
</head>
	<body>
		<div id="main">
			<div class="mainbox">
				<div class="title readMessage png"></div>
				<%@include file="menu.jsp" %>
				<h1>阅读邮件</h1>
				<div class="content">
					<div class="message">
							<div class="tmenu">
								<ul class="clearfix">
									<li>标题: ${fn:escapeXml(requestScope.get("title"))} </li>
									<li>来自：${fn:escapeXml(requestScope.get("sender"))}</li>
									<li>时间：${fn:escapeXml(requestScope.get("time"))}</li>
								</ul>
							</div>
					  	 	<div class="view">
								<p>${fn:escapeXml(requestScope.get("content"))}</p>
							</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
