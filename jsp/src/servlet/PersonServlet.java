package servlet;

import dao.PersonDao;
import entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 描述：处理person表请求的servlet
 * 2.实现servlet - 继承HttpServlet(父类是Servlet接口)
 * @author songsong
 * @create 2019/12/11 11:09
 * servlet
 *   servlet-name
 *   servlet-class    servlet.PersonServlet
 *   init-param
 *   load-on-startup
 * serlvet-mapping
 *   servlet-name
 *   url-pattern    /show
 */
//注解配置  通过注解方式可以简化配置文件的开发
//@WebServlet("/show")  //  url-pattern  默认值
@WebServlet(
        name = "person", //servlet-name
        urlPatterns = {"/show"},  //url-pattern
        loadOnStartup = 1,   //load-on-startup
        initParams = {@WebInitParam(name="charset",value="utf-8")} //init-param
)
public class PersonServlet  extends HttpServlet{
    @Override   //用于处理get请求
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //application ==》ServletContext
        //String charset=getInitParameter("charset");
        //System.out.println(charset+"===================");
        //处理查询所有数据请求
        //1.转码  2.获取数据  3.判断跳转
        //调用service-dao---jdbc ===返回list--传递 给客户端
        //如何数据传递  1.可以通过xml 2. 通过json
        // 3.可以通过地址栏传递  url?name=value   只能传递字符串 (对象  集合 不能够传递)
        // 4.通过四大作用域 传递
        /*
        当前页数、每页条数   pageIndex2    pageCount5
        select *(select 表.*,rownum r from 表) where r between 1 and 5
        select *(select 表.*,rownum r from 表) where r between 6 and 10
        select *(select 表.*,rownum r from 表) where r between 11 and 15
        select *(select 表.*,rownum r from 表)
        where r between (pageIndex-1)*pageCount+1 and (pageIndex*pageCount)
        */
        //如何获取session作用域   类型 HttpSession
        HttpSession session=req.getSession();
        //获取前台传递过来的当前页数和每页条数
        String pageIndex=req.getParameter("pageIndex");
        String pageCount=req.getParameter("pageCount");
        if(pageIndex==null){ //第一次默认第一页
            pageIndex="1";
        }
        if(pageCount==null){ //默认每页5条
            pageCount=(String)session.getAttribute("pageCount");
            if(pageCount==null) pageCount="5";  //既每页存作用域 也没有传递每页条数
        }else{    //第一次修改每页条数
            session.setAttribute("pageCount",pageCount);
        }
        Integer index=Integer.parseInt(pageIndex);  //当前页数
        Integer count=Integer.parseInt(pageCount);  //每页条数
        PersonDao pd=new PersonDao();
        List<Person> list=pd.queryAll(index,count);//查询指定页的数据  pageIndex  pageCount
        req.setAttribute("list",list);
        //传递当前页
        req.setAttribute("pageIndex",index);
        //传递总页数
        int totalCount=pd.queryCount();
        int totalPage=totalCount%count==0?totalCount/count:(totalCount/count+1);
        req.setAttribute("totalPage",totalPage);

        //下拉列表需要默认值


        req.getRequestDispatcher("day5/showPerson.jsp").forward(req,resp);
    }

    @Override  //用户处理post请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
