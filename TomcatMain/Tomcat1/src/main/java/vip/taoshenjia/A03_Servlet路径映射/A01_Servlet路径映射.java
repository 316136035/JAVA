package vip.taoshenjia.A03_Servlet路径映射;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class A01_Servlet路径映射 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.getWriter().print(
                "<div>"+"优先级： 完全路径匹配 > 目录匹配 > 扩展名匹配"+"</div>"
                + "<div>"+"目录匹配     /Tomcat_war_exploded/"+"</div>"
                + "<div>"+"扩展名匹配    *.do"+"</div>");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
