package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Bmo
 * @date 2019/12/16 19:37
 */
@WebServlet("/ajaxHomework")
public class HomeWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求进入");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        String sender = request.getParameter("sender");
        String content = request.getParameter("content");
        map.put("sender", sender);
        map.put("content", content);
        String result = mapper.writeValueAsString(map);
        response.getWriter().write(result);
    }
}
