package vip.taoshenjia.A04_ServletContex所有用户需要共享的线程又是安全;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class A05_ServletContex的API extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = this.getServletContext().getContextPath();
        System.out.println("获取项目路径:"+ contextPath);
        String realPath = this.getServletContext().getRealPath("/img.png");
        System.out.println( "获取文件路径:"+realPath);
        response.getWriter().print("请查看ServletContex的API");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
