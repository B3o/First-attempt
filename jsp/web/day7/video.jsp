<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<script src="/jsp/js/jquery-3.0.0.min.js"></script>
	<style>
		body{
			position: relative;
		}
		#commentArea{
			float: left;
			position: fixed;
			bottom: 200px;
			right: 200px;
		}
	</style>
</head>
<body>
<div style="width:730px; margin:20px auto;">
	<video controls="controls" autoplay>
		<source src="mysql.mp4" type="video/mp4" >示例视频1</source>
		您的浏览器不支持video标签
	</video>
	<p><span style="font-weight:bold; font-size:20px; color:blue;">点赞</span> &nbsp;<span style="background-color:green; padding:5px; border-radius:5px">36</span>
	</p>
	<hr>
	<h3>评论列表</h3>
	<div id="messages">
		<p>张三说：这视频太好看了！！！ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2016-08-12</p>
		<p>李四说：唱的填好了！！ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2016-08-12</p>
	</div>
	<hr>

</div>
<div id="commentArea">
	姓名：<input size="10" placeholder="请输入姓名" name="sender"/><br><br>
	<textarea placeholder="请输入评论内容" id="content"></textarea><br><br>
	<button id="commentBtn">发表评论</button>
</div>
</body>
<script>
	$(function () {
		$("#commentBtn").click(function () {
		    var sender = $("input[name='sender']").val();
		    var content = $("#content").val();
		    $.post("/jsp/ajaxHomework", {"sender": sender, "content": content}, function (data) {
				$("#messages").append("<p>" + data.sender + "说:" + data.content + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
            }, "json")
        })
    })
</script>
</html>