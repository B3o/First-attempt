<%@ page import="util.DBUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("un");
        String password = request.getParameter("pw");
        UserDao ud = new UserDao();
        User u = ud.queryByUsernamePassword(username, password);
        if (u != null) {
            session.setAttribute("login_condition", u);
            session.setMaxInactiveInterval(1200);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        /*
        if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
//            成功的话就跳转至欢迎页面
//            请求转发 跳转   地址只能写相对路径
//            request.getRequestDispatcher("转发的地址").forward(请求, 响应);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
//            重定向
        } else {
//            失败则回到登陆页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }*/
    %>
</body>
</html>
