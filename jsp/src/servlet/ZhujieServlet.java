package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bmo
 * @date 2019/12/11 14:10
 */
//@WebServlet("/zhujie") url-pattern 默认值
    @WebServlet(
            displayName = "",
            name = "person",
            urlPatterns = {"/zhujie"},
            loadOnStartup = 1,
            initParams = {@WebInitParam(name = "charset", value = "utf-8")}
    )
public class ZhujieServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getInitParameter("name");


    }
}
