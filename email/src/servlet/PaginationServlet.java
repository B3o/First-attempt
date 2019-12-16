package servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpRequest;
import dao.MailDao;
import entity.Mail;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bmo
 * @date 2019/12/11 14:44
 * 此处应该添加过滤器,防止非法请求
 */
@WebServlet("/mailRow")
public class PaginationServlet extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    HttpSession session;
    MailDao md = new MailDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        if ("ajaxMails".equals(type)) {
            respMailsByRowNum(request, response);
        }else if ("search".equals(type)) {
            respMailsBySearch(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    private void respMailsBySearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        String search = "";
        User user = null;
        user = (User) session.getAttribute("user");
        search = request.getParameter("search");
        String temp = request.getParameter("rowNum");
        int rowNum;
        if (temp == null || "".equals(temp)) {
            rowNum = 1;
        } else {
            rowNum = Integer.valueOf(temp);
        }
        List<Mail> mails = md.searchMails(search, user.getUsername(), rowNum);
        int totalPage = md.searchTotalPage(search, user.getUsername());
        session.setAttribute("mailrownum", totalPage);
        if (mails.size() > 0) {
            session.setAttribute("mails", mails);
        }
        map.put("mails", mails);
        map.put("mailrownum", totalPage);
        String result = mapper.writeValueAsString(map);
        response.getWriter().write(result);
//        response.getWriter().write("{\"mailrownum\" : " + totalPage +"}");
    }
    private void respMailsByRowNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session = request.getSession();
        User user = null;
        user = (User) session.getAttribute("user");
        String temp = request.getParameter("rowNum");
        if (temp == null || "".equals(temp)) {
            return;
        }
        int rowNum = Integer.valueOf(temp);
        List<Mail> mails = md.queryMails(rowNum, user.getUsername());
        if (mails.size() > 0) {
            session.setAttribute("mails", mails);
        }
        String result = mapper.writeValueAsString(mails);
        response.getWriter().write(result);
    }
}
