<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/10
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="username" value="李四" scope="session"></c:set>
${sessionScope.username}
</body>
</html>
