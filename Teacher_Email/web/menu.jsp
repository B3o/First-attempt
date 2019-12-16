<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="menu">
				<span>当前用户：<a href="/email/email">${user.username}</a></span> <span><a href="/email/user?type=queryAll">发送邮件</a></span>
				<span><a href="yifaMsg.jsp">已发邮件</a></span> <span><a href="">退出</a></span>
			</div>