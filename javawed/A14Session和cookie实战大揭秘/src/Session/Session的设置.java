package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Session的设置",urlPatterns = "/Session的设置")
public class Session的设置 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //session对象得的标识存放在cookie中有key和valve(没有办法获取数据)  数据存放在服务器

       //获取session对象
        HttpSession session = request.getSession();
        //向session内存入内容
        session.setAttribute("key","valve");
        //向session内存入对象
        session.setAttribute("key1",new Text("damin","123456"));
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("向session内存入内容");


    }
}
