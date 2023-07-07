package vip.taoshenjia.A01_Servlet运行状态;
import javafx.scene.control.SplitPane;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***继承HttpServlet 只能处理Http的请求*/
public class A01_Servlet运行状态 extends HttpServlet {
    /**当Tomcat创建Servlet实例后，马上调用init()方法。这个方法只在创建后调用一次！用来做Servlet初始化工作！
      一个Servlet实例只被创建一次，所以init()方法也只被调用一次！（本方法编写对Servlet的初始化代码）*/
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init()Servlet实例后，马上调用");
    }

    /**这个方法返回ServletConfig对象，但我们不能自己去创建ServletConfig对象，
     所以一般我们会在init()方法中把init()方法的参数保存起来，然后再在本方法中返回它。
      ServletConfig对象对应web.xml中当前Servlet实例的配置信息。*/
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig()ServletConfig对象");
        return super.getServletConfig();
    }

    /**Servlet实例在每次处理请求时都调用service()方法。一般用doGet和doPost*/
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("service()请求时都调用");
//    }

    /**这个方法只是返回一个字符串，定义用来说明当前Servlet。基本没用！*/
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()返回一个字符串");
        return super.getServletInfo();
    }
    /**当Tomcat要销毁Servlet实例时，会先调用destroy()方法，再销毁它。所谓销毁Servlet，
     其实就是在Servlet缓存池中把Servlet移除！一般只有Tomcat关闭时，才会销毁Servlet实例！*/
    @Override
    public void destroy() {
        System.out.println("destroy()销毁");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(
                "<div>"+"当Tomcat创建Servlet实例后，马上调用init()方法。这个方法只在创建后调用一次！用来做Servlet初始化工作！一个Servlet实例只被创建一次，所以init()方法也只被调用一次！（本方法编写对Servlet的初始化代码）"+"<div>"
               +"<div>"+"ServletConfig()方法返回ServletConfig对象，但我们不能自己去创建ServletConfig对象，所以一般我们会在init()方法中把init()方法的参数保存起来，然后再在本方法中返回它。ServletConfig对象对应web.xml中当前Servlet实例的配置信息。"+"<div>"
               +"<div>"+"Servlet实例在每次处理请求时都调用service()方法。一般用doGet和doPost"+"<div>"
               +"<div>"+"当Tomcat要销毁Servlet实例时，会先调用destroy()方法，再销毁它。所谓销毁Servlet.其实就是在Servlet缓存池中把Servlet移除！一般只有Tomcat关闭时，才会销毁Servlet实例！"+"<div>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



}
