package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.glassfish.gmbal.ParameterNames;
import entity.Person;
import javafx.scene.control.Pagination;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.Date;

/**
 * @author Bmo
 * @date 2019/12/10 19:19
 */
@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String contextPath = getServletContext().getContextPath();
        System.out.println(contextPath);
//        String json = mapper.writeValueAsString(new Person("礼物礼物", 18, "男", new Date()));
//        response.getWriter().write(json);
//        response.sendRedirect("https://api.jquery.com/category/ajax/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
