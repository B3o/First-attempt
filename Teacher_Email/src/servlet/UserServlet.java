package servlet;

import pojo.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/12 10:25
 * 用于处理用户表的所有请求
 */
@WebServlet("/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    UserService us = new UserService();
    HttpSession session;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        if ("reg".equals(type)) {
            register(request, response);
            //处理User注册
        }else if ("login".equals(type)) {
            login(request, response);
            //处理User登陆
        }else if ("queryAll".equals(type)){
            queryAll(request, response);
        }

    }
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
//       依赖于servece做业务(功能执行是否成功失败 可能包含很多子功能  转换数据类型等 做事务 做异常 做日志)
        if (us.register(username, password, email)) {
            response.sendRedirect("/email/index.jsp");
        } else {
            //注册失败
            response.sendRedirect("/email/register.jsp");
        }
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = us.login(username, password);
        if (u != null) {
            session = request.getSession();
            session.setAttribute("user", u);
//            先调用servlet查询当前登录的用户接受的邮件
//            可以在这里添加cookie
            response.sendRedirect("/email/email");
        } else {
            response.sendRedirect("/email/index.jsp");
        }
    }
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = us.queryAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("newMsg.jsp").forward(request, response);
    }

}
