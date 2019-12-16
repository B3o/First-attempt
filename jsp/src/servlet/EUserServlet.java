package servlet;

import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Bmo
 * @date 2019/12/16 9:44
 */
@WebServlet(value = "/register", loadOnStartup = 1)
@MultipartConfig //标注 Servlet支持上传文件
public class EUserServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
//        定义一个初始化, 让服务器启动运行,获取项目前缀 存入作用域
        String prefix = config.getServletContext().getContextPath();
        config.getServletContext().setAttribute("prefix", prefix);
        System.out.println("项目前缀为:" + prefix);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("myFile");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        //数据保存? 在服务器项目路径中提供一个包upload 这个包用来保存上传文件内容
        //数据库保存upload下的路径名,下次想获取  通过数据库查询路径
//        通过part对象获取文件名(tomcat8支持)
        String fileName = part.getSubmittedFileName();
//        获取项目真实路径
        String realPath = request.getServletContext().getRealPath("/upload");
        String tempPath = request.getServletContext().getContextPath();
//        项目路径固定的+ 随机生成的文件名+文件后缀名
//        文件名随机生成方式:随机数 时间戳 UUID

        String name = UUID.randomUUID().toString();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀名:" + suffix);
        String path = realPath + File.separator + name + suffix;
        System.out.println("文件上传路径为:" + path);
//        将上传文件保存到指定路径path
        part.write(path);
//        CRUD 持久化
        UserService us = new UserService();
        boolean b = us.register(username, password, name + suffix);
        if (b) {
            response.sendRedirect(request.getContextPath() + "/day7/login.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/day7/register.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
