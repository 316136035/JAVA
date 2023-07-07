package A04响应对象response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Response功能介绍",urlPatterns = "/Response功能介绍")
public class Response功能介绍 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        //通过响应对象response设置网页的响应内容
      //  response.addHeader("key","vlava");
        //通过响应对象response设置网页N秒后自动跳转到百度
        //response.addHeader("reFresh","10;url=Http://www.baidu.com");
        //通过响应对象response设置网页的页面内容
       // response.getWriter().write("<h1 >爱你!</h1>");
        //通过响应对象response设置网页的页面内容带换行
        response.getWriter().print("通过响应对象response设置网页的页面内容带换行");
        //发送状态码
        //response.sendError(404);
        //使用响应对象进行请求重定向302
    response.sendRedirect("/A13requestresponse_Web_exploded/响应对象response/1.html");






    }
}
