package ServletContex存储和读取;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletContex存储",urlPatterns = "/ServletContex存储")
public class ServletContex存储 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContex对象
        ServletContext servletContext = getServletContext();
        //存储内容
        servletContext.setAttribute("key1" ,"valve1");
        servletContext.setAttribute("key2" ,"valve2");
        servletContext.setAttribute("key3" ,"valve3");
        System.out.println("servletContext存储成功");


    }
}
