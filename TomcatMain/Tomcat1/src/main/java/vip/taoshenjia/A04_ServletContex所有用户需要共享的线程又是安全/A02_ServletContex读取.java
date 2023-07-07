package vip.taoshenjia.A04_ServletContex所有用户需要共享的线程又是安全;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


public class A02_ServletContex读取 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取getServletContext对象
        ServletContext servletContext = this.getServletContext();
        String vavle1 = (String) servletContext.getAttribute("key1");
        String vavle2 = (String) servletContext.getAttribute("key2");
        String vavle3 = (String) servletContext.getAttribute("key3");
        resp.getWriter().print(vavle1+vavle2+vavle3+"获取ServletContext().Attribute()成功...");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,  resp);
    }
}
