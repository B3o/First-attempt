package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/15 18:09
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    UserService us = new UserService();
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        if ("reg".equals(type)) {
            register(request, response);
        }else if ("login".equals(type)) {
            login(request, response);
        }else if ("exit".equals(type)) {
            exit(request, response);
        }else if ("queryAll".equals(type)) {
            queryAll(request, response);
        }
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = us.queryAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("newMsg.jsp").forward(request, response);
    }

    private void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = us.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(3600);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            response.sendRedirect("mail?type=show");
//            req.getRequestDispatcher("/receiver").forward(req, resp);
        } else {
            request.setAttribute("error", "密码错误,请重新输入!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (us.register(username, password)) {
            request.setAttribute("successInfo", "注册成功!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            request.setAttribute("error", "注册失败!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
