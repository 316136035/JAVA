package ServletContex统计请求次数;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContex", urlPatterns = "/ServletContex统计请求次数")
public class ServletContex extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取servletContext对象
        ServletContext servletContext = getServletContext();
        //通过servletContext对象获取到valve
        Integer valve = (Integer) servletContext.getAttribute("key");
        //第一次请求获取不到就是null
        if (valve == null) {
            valve = 0;
            }
        // valve++
        valve++;
        //设置servletContext的键值对
        servletContext.setAttribute("key",valve);
        System.out.println(valve);
        //向客户端返回响应内容
        response.getWriter().write("key:"+valve);



    }
}
