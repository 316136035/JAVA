package Myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//扩展名匹配  网页地址为http://localhost:9090/Servlet%E8%B7%AF%E5%BE%84%E6%98%A0%E5%B0%84(%E7%86%9F%E7%BB%83)/？？？？？.do
@WebServlet(name = "MyServlet3",urlPatterns = "*.do")
public class MyServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet3被调用了");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet3被调用了");
    }
}
