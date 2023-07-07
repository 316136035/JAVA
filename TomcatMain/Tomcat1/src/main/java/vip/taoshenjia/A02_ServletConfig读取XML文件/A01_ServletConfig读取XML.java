package vip.taoshenjia.A02_ServletConfig读取XML文件;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
/***继承HttpServlet 只能处理Http的请求*/
public class A01_ServletConfig读取XML extends HttpServlet {

    /**当Tomcat创建Servlet实例后，马上调用init()方法。这个方法只在创建后调用一次！用来做Servlet初始化工作！
     一个Servlet实例只被创建一次，所以init()方法也只被调用一次！（本方法编写对Servlet的初始化代码）*/
    @Override
    public void init() throws ServletException {
        //获取ServletConfig对象(只能获取当前的Srevlet的初始化参数)
        ServletConfig config = getServletConfig();
        /*通过key取消valve*/
        String username = config.getInitParameter("username");
        System.out.println(username);
        /**ServletConfig对象获取枚举对象*/
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        /*遍历枚举*/
        while (initParameterNames.hasMoreElements()) {
            //获取每一个 key
            String key = initParameterNames.nextElement();
            //通过key获取到valve
            String valve = config.getInitParameter(key);
            System.out.println(key+"="+valve);
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        resp.getWriter().print("A01_ServletConfig读取XML成功...");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
