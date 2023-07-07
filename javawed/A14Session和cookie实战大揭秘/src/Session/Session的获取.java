package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Session的获取", urlPatterns = "/Session的获取")
public class Session的获取 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //session对象得的标识存放在cookie中有key和valve(没有办法获取数据)  数据存放在服务器
        //获取session
        HttpSession session = request.getSession();

        System.out.println(session.getId());
        //获取session中数据
        Object key = session.getAttribute("key");
        System.out.println(key);
        Object key1 = session.getAttribute("key1");
        Text text = (Text) key1;
        System.out.println(text.toString());
        //让对应的session方法注销
       // session.invalidate();
        //session的全项目的超时时间，以分钟为单位  在xml中配置

    }
}
