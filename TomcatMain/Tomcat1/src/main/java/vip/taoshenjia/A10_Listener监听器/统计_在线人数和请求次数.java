package vip.taoshenjia.A10_Listener监听器;


import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class 统计_在线人数和请求次数 implements ServletContextListener, HttpSessionListener, ServletRequestListener {
    /**
     * Tomcat服务器开启就调用contextInitialized（）
     **/
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /**获取ServletContext全局变量*/
        ServletContext servletContext = sce.getServletContext();
        /**ServletContext全局变量设置参数 在线用户数量*/
        servletContext.setAttribute("USERCOUNT", 0);
        /**ServletContext全局变量设置参数 请求次数*/
        servletContext.setAttribute("Numberofrequests", 0);
    }

    /**
     * Tomcat服务器关闭调用contextDestroyed（）
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * Session会话创建就调用sessionCreated()
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println( se.getSession().getId());
        /**获取ServletContext全局变量*/
        ServletContext servletContext = se.getSession().getServletContext();
        /**获取ServletContext全局变量参数,强转成Integer类型*/
        Integer usercount = (Integer) servletContext.getAttribute("USERCOUNT");
        usercount++;
        /**ServletContext全局变量设置参数*/
        servletContext.setAttribute("USERCOUNT", usercount);


    }

    /**
     * Session会话销毁就调用sessionCreated()
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /**获取ServletContext全局变量*/
        ServletContext servletContext = se.getSession().getServletContext();
        /**获取ServletContext全局变量参数,强转成Integer类型*/
        Integer usercount = (Integer) servletContext.getAttribute("USERCOUNT");
        usercount--;
        /**ServletContext全局变量设置参数*/
        servletContext.setAttribute("USERCOUNT", usercount);

    }

    /**当wed页面请求过来就会调用requestInitialized() */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext servletContext = sre.getServletContext();
        /**获取ServletContext全局变量参数,强转成Integer类型*/
        Integer usercount = (Integer) servletContext.getAttribute("Numberofrequests");
        usercount++;
        sre.getServletContext().setAttribute("Numberofrequests", usercount);


    }

    /**当请求销毁就会调用requestDestroyed( */

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
       // System.out.println("requestDestroyed");

    }


}
