package Listener监听器;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class 完整讲解Listener监听器 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("contextInitialized当服务器启动就调用");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextInitialized当服务器关闭前调用");
    }


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated回话创建就调调用");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionCreated回话销毁就调用");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("sessionCreated添加属性的时候调用");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("sessionCreated删除属性的时候调用");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("sessionCreated修改属性的时候调用");
    }
}
