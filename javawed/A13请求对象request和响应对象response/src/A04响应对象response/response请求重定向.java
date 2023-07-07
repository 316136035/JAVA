package A04响应对象response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "response请求重定向", urlPatterns = "/response请求重定向")
public class response请求重定向 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Response请求重定向
使用response对象的sendRedirect()方法能够将网页重定向到还有一个页面。
重定向支持将地址重定向到不同的主机上，这一点与转发不同。
在client浏览器上将会得到跳转后的地址，并又一次发送请求链接；
用户能够从浏览器的地址栏中看到跳转后的地址；
重定向操作后，request中的属性将会所有失效，并開始一个新的request对象*/
        //Status Code: 302 就是重定向
        // response.sendRedirect("1.html");
        //Response请求重定向可以请求到外网
        response.sendRedirect("https://www.jd.com/");
    }
}
