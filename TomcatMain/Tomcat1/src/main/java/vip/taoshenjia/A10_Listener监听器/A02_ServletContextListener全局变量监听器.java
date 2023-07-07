package vip.taoshenjia.A10_Listener监听器;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*监听 ServletContext创建和销毁*/
public class A02_ServletContextListener全局变量监听器 implements ServletContextListener{

    //Tomcat启动和关闭时调用下面两个方法:
    @Override
    public void contextInitialized(ServletContextEvent sce) {
     //   System.out.println("ServletContextEvent---Tomcat启动调用后被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
     //   System.out.println("ServletContextEvent----Tomcat关闭时被销毁前调用");
    }

}
