package 创建HttpServlet的第二种方法;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//这个是注解 类名,要映射的地址  *(直接用创建类的方式)
@WebServlet(name = "创建HttpServlet的第二种方法",urlPatterns = "/httpservlet2")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost请求被调用了" );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget请求被调用了" );
    }
}
