package servlet;

import entity.EUser;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bmo
 * @date 2019/12/16 11:45
 */
@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService us = new UserService();
        String un = request.getParameter("username");
        String pw = request.getParameter("password");
        EUser u = us.login(un, pw);
        if (u != null) {
            request.getSession().setAttribute("u", u);
            response.sendRedirect(request.getContextPath() + "/showUser");
        } else {
            response.sendRedirect(request.getContextPath() + "/day7/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
