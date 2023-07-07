package ServletContex统计请求次数;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContex1", urlPatterns = "/ServletServletContex统计请求次数1")
public class ServletContex1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取servletContext对象
        ServletContext servletContext = getServletContext();
        //通过servletContext对象获取到valve
        Integer valve = (Integer) servletContext.getAttribute("key");
        if (valve == null) {
            valve = 0;
            }
        valve++;
        servletContext.setAttribute("key",valve);
        System.out.println(valve);



    }
}
