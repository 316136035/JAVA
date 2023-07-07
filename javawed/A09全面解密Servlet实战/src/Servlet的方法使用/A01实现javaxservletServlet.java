package Servlet的方法使用;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

;

public class A01实现javaxservletServlet implements  javax.servlet.Servlet {
    /**当Tomcat创建Servlet实例后，马上调用init()方法。这个方法只在创建后调用一次！用来做Servlet初始化工作！
    // 一个Servlet实例只被创建一次，所以init()方法也只被调用一次！（本方法编写对Servlet的初始化代码）*/
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("实现javaxservletServlet的init方法被调用了");

        }
    /**这个方法返回ServletConfig对象，但我们不能自己去创建ServletConfig对象，
    // 所以一般我们会在init()方法中把init()方法的参数保存起来，然后再在本方法中返回它。
    // ServletConfig对象对应web.xml中当前Servlet实例的配置信息。*/
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /**Servlet实例在每次处理请求时都调用service()方法。*/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("实现javaxservletServlet的service方法被调用了");
    }
    /**这个方法只是返回一个字符串，定义用来说明当前Servlet。基本没用！*/
    @Override
    public String getServletInfo() {
        String s="这个方法只是返回一个字符串，定义用来说明当前Servlet";
        return  s;
    }
   /**当Tomcat要销毁Servlet实例时，会先调用destroy()方法，再销毁它。所谓销毁Servlet，
    // 其实就是在Servlet缓存池中把Servlet移除！一般只有Tomcat关闭时，才会销毁Servlet实例！*/
    @Override
    public void destroy() {
        System.out.println(" 实现javaxservletServlet的destroy方法被调用了");
    }
}
