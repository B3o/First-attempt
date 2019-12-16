package servlet;

import entity.Mail;
import entity.User;
import service.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/12/15 19:08
 *
 */
@WebServlet("/mail")
public class MailServlet extends HttpServlet {
    MailService ms = new MailService();
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String type = request.getParameter("type");
        if ("show".equals(type)) {
            showMails(request, response);
        }else if ("readMsg".equals(type)) {
            readMsg(request, response);
        }else if ("send".equals(type)) {
            sendMail(request, response);
        }else if ("delReceive".equals(type)) {
            delReceive(request, response);
        }else if ("delAllReceive".equals(type)) {
            delAllReceive(request, response);
        }
    }


    private void sendMail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String receiver = request.getParameter("toUser");
        String sender = ((User)session.getAttribute("user")).getUsername();
        boolean b = ms.sendEmail(title, content, sender, receiver);
        PrintWriter out = response.getWriter();
        if (b) {
            out.print("<script>alert('邮件发送成功!');location.href='/mail?type=show'</script>");
        } else {
            out.print("<script>alert('邮件发送失败!');location.href='/mail?type=show'</script>");
        }
    }

    /**
     * type=readMsg&mailId=
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void readMsg(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<Mail> mails = (List) session.getAttribute("mails");
        int mailNum = -1;
        String mailId = null;
        mailId = request.getParameter("mailId");
        if (mailId == null || "".equals(mailId) || "null".equals(mailId)) {
            response.sendRedirect("main.jsp");
            return;
        } else {
            mailNum = Integer.valueOf(mailId);
        }
        if (mailNum > 0) {
            for (Mail mail : mails) {
                if (mail.getId() == mailNum) {
                    request.setAttribute("title", mail.getTitle());
                    request.setAttribute("sender", mail.getSender());
                    request.setAttribute("time", mail.getTime());
                    request.setAttribute("content", mail.getContent());
                    request.getRequestDispatcher("readMsg.jsp").forward(request, response);
                }
            }
        }
        response.sendRedirect("main.jsp");
        return;
    }

    /**
     * type=show?page=页数,默认访问第一页
     * @param request
     * @param response
     * @throws IOException
     */
    private void showMails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Mail> mails = new ArrayList<>();
        session = request.getSession();
        User user = (User) session.getAttribute("user");
        String page = request.getParameter("page");
        if (page != null && !"".equals(page) && !"null".equals(page)) {
            Integer pageNum = Integer.valueOf(page);
            mails = ms.queryReceiverMails(pageNum, user.getUsername());
        } else {
            mails = ms.queryReceiverMails(1, user.getUsername());
            int totalPage = ms.queryTotalPages(user.getUsername());
            session.setAttribute("mailrownum", totalPage);
        }
            session.setAttribute("mails", mails);
            response.sendRedirect("main.jsp");
    }
    private void delReceive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        boolean b = ms.delReceive(id);
        PrintWriter out = response.getWriter();
        if (b) {
            out.print("<script>alert('删除成功!');location.href='/mail?type=show'</script>");
        } else {
            out.print("<script>alert('删除失败!');location.href='/mail?type=show'</script>");
        }
    }
    private void delAllReceive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("ck");
        PrintWriter out = response.getWriter();
        if (ms.delAllReceive(ids)) {
            out.print("<script>alert('删除成功!');location.href='/mail?type=show'</script>");
        } else {
            out.print("<script>alert('删除失败!');location.href='/mail?type=show'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
}
