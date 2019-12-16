<%@ page import="dao.UserDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/5
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--修改的控制页面 做什么?
     1.转码   2.取值    3.判断跳转--%>
<%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String un = request.getParameter("un");
    String pw = request.getParameter("pw");
    String time = request.getParameter("birthday");
    String sex = request.getParameter("sex");
    String age = request.getParameter("age");
    UserDao ud = new UserDao();
    int i = ud.updateById(id, un, pw, time, sex, Integer.valueOf(age));
    if (i > 0) {
        out.print("<script>alert('修改成功');location.href='/jsp/day3/welcome.jsp'</script>");
//        response.sendRedirect("welcome.jsp");
    } else {
        out.print("<script>alert('修改失败');location.href='/jsp/day3/welcome.jsp'</script>");
//        response.sendRedirect("welcome.jsp");
    }
%>


</body>
</html>
