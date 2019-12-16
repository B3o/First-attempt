<%--
  Created by IntelliJ IDEA.
  User: Bmo
  Date: 2019/12/4
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>展示用户登陆:</h1>
    <%
        //        修改请求数据的编码方式
        request.setCharacterEncoding("utf-8");//针对post方式
        String username = request.getParameter("un");
        String password = request.getParameter("pw");
        String sex = request.getParameter("sex");
        //通过表单组件name  获取多个value 返回String[]
        String[] cks = request.getParameterValues("ck");
        String comment = request.getParameter("comment");
        String birthday = request.getParameter("birthday");
        String area = request.getParameter("city");
        String head = request.getParameter("head");
//        get方式提交数据时    tomcat7 需要 打散重组 tomcat8 默认处理
//        sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
    %>
    <p>用户: <%=username%></p>
    <p>密码: <%=password%></p>
    <p>性别: <%=sex%></p>
    <p>爱好:
        <%
            if (cks != null) {
                for (String s : cks) {
                    out.print(s + "  ");
                }
            }
        %>
    </p>
    <p>备注:<%=comment%></p>
    <p>生日: <%=birthday%></p>
    <p>祖籍: <%=area%></p>
    <p>头像: <%=head%></p>
    <p>
        <%
            String hehe = request.getParameter("hehe");
            String like = request.getParameter("like");
        %>
        id:<%=hehe%>
        like:<%=like%>
        time:<%=birthday%>
    </p>
</body>
</html>
