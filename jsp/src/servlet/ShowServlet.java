package servlet;

import entity.EUser;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/16 14:22
 */
@WebServlet("/showUser")
public class ShowServlet extends HttpServlet {
    UserService us = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EUser> list = us.queryAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("day7/show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
