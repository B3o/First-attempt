<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/9
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //实现网站计数器
//    第一次访问 创建一个变量 存储1
//    当非第一次访问  取出原来的值,加1 存入
    Integer count = (Integer)application.getAttribute("count");
    if (count == null) {
        application.setAttribute("count", 1);
    }else {
        count++;
        application.setAttribute("count", count);
    }
    request.getRequestDispatcher("count.jsp").forward(request, response);

%>

</body>
</html>
