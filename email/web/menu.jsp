<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.User" %>
<%
	request.setCharacterEncoding("utf-8");
	User user = (User) session.getAttribute("user");
	if (user == null) {
	    request.setAttribute("error", "请先登陆!");
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>
<div class="menu">
				<span>当前用户：<a href="/mail?type=show">${sessionScope.user.username}</a></span> <span><a href="user?type=queryAll">发送邮件</a></span>
				<span><a href="yifaMsg.jsp">已发邮件</a></span> <span><a href="/user?type=exit">退出</a></span>
</div>