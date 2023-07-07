package Myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//优先级： 完全路径匹配 > 目录匹配 > 扩展名匹配
//        经典错误：  /*.do
////完全路径匹配
@WebServlet(name = "MyServlet1",urlPatterns = "/MyServlet/MyServlet1")
public class MyServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyServlet1被调用了");
    }
}
