package servlet;

import pojo.Email;
import pojo.User;
import service.EmailService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/12 15:40
 */
@WebServlet("/email")
public class EmailServlet extends HttpServlet {
    EmailService es = new EmailService();
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String type = request.getParameter("type");
        session = request.getSession();
        if(type == null) { //查询所有当前用户接受邮件
            queryToUser(request, response);
        }else if ("add".equals(type)) {
            addEmail(request, response);
        }else if ("del".equals(type)) {
            del(request, response);
        }else if ("delAll".equals(type)) {
            delAll(request, response);
        }
    }

    public void delAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("ck");
        PrintWriter out = response.getWriter();
        if (es.delAll(ids)) {
            out.print("<script>alert('删除成功');location.href='/email/email';</script>");

        } else {
            out.print("<script>alert('删除失败');location.href='/email/email';</script>");

        }
    }
    public void addEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String toUser = request.getParameter("toUser");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String fromUser = ((User)session.getAttribute("user")).getUsername();
        boolean b = es.addEmail(fromUser, toUser, title, content);
        PrintWriter out = response.getWriter();
        if (b) {
            out.print("<script>alert('邮件发送成功!');location.href='/email/main.jsp'</script>");
        } else {
            out.print("<script>alert('邮件发送失败!');location.href='/email/main.jsp'</script>");
        }
    }
    public void queryToUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        User u = (User)session.getAttribute("user");
        List<Email> toUserList;
        if (search == null) {
            toUserList = es.queryToUser(u.getUsername());
        } else {
            toUserList = es.querySearchUser(u.getUsername(), search);
        }
        request.setAttribute("toUserList", toUserList);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        boolean b = es.delete(id);
        PrintWriter out = response.getWriter();
        if (b) {
            out.print("<script>alert('删除成功');location.href='/email/email';</script>");
        } else {
            out.print("<script>alert('删除失败');location.href='/email/email';</script>");
        }
    }
}
