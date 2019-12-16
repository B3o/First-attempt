package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Bmo
 * @date 2019/12/16 15:03
 */
@WebServlet("/download")
public class DownLoadServlet extends HttpServlet {
//    下载功能
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        转码
        request.setCharacterEncoding("utf-8");
//        获取文件名
        String fileName = request.getParameter("fileName");
//        获取文件真实路径
        String path = request.getServletContext().getRealPath("/upload/" + fileName);
//        获取文件类型
        String mimeType = request.getServletContext().getMimeType(path);
        System.out.println("文件格式:" + mimeType);
//        设置响应的文件类型
        response.setContentType(mimeType);
//        设置响应头部信息,指定为附件形式下载,并且指定文件名
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
//        获取响应的输出流
        ServletOutputStream sos = response.getOutputStream();
//        通过输入流先读文件
        FileInputStream fis = new FileInputStream(path);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = fis.read(buffer)) != -1) {
            sos.write(buffer, 0, length);
        }
        fis.close();
        sos.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
