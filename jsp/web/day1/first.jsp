<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/3
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--java脚本代码--%>
<%
    int a = 100;
    int b = 200;
    int c = a + b;
    //打印在控制台
    System.out.println("运行结果为:" + c);
    //打印在页面
    out.print("运行结果(页面)" + c);
%>
<%--第二种 在页面打印的方式 借助于脚本表达式语言--%>
求和的结果是:<%=c%>
first页面
</body>
</html>
