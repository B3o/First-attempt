<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/10
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("number", 0.897865);
    Date date = new Date();
    request.setAttribute("date", date);
%>
<%--fmt做数据格式化(数字 日期等)--%>
<%--
formatNumber实现数字格式化
value:指定格式化的数字(可以写实际的值,EL表达式)
maxFractionDigits:指定保留的小数位,会进行四舍五入
type:number为数字  percent百分比  currency 显示金额(货币)
pattern:可以指定数字的格式  0表示数字

--%>

<fmt:formatNumber value="123456789.123456789" maxFractionDigits="2" ></fmt:formatNumber>
<br>
<fmt:formatNumber value="${requestScope.get('number')}" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
<br>
<fmt:formatNumber value="0.896568" type="percent" maxFractionDigits="3"></fmt:formatNumber>
<br>
<fmt:formatNumber type="currency" value="9871165.1234" maxFractionDigits="2" pattern="$.00"></fmt:formatNumber>
<br>
<h2>转换前:${date}</h2>
<h2>转换后:</h2>
<fmt:parseDate pattern="yyyy-MM-dd" value="2019-06-04"></fmt:parseDate>
<h2>转换后2:</h2>
<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${date}"></fmt:formatDate>
</body>
</html>
