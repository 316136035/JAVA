package 在线人员实时统计;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class Listenert统计在线人数 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener {
    //定义初始化参数
    private Integer 在线人数;
    private  Integer 请求次数;

    /**当服务器启动就会调用在这个方法*/
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("(ServletContext 创建成功");
        //定义初始化参数
        在线人数=0;
        //获取ServletContext对象
        sce.getServletContext().setAttribute("renshu",  在线人数);
        请求次数=0;
        //获取ServletContext对象
        sce.getServletContext().setAttribute("cishu",  请求次数);

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("当前servler销毁前调用");

    }


    public void sessionCreated(HttpSessionEvent se) {

        //获取ServletContext()参数的在线人数
       Integer renshu = (Integer)se.getSession().getServletContext().getAttribute("renshu");
        Integer integer = ++renshu;

        //从新设置ServletContext()参数的在线人数
        se.getSession().getServletContext().setAttribute("renshu",renshu);
        System.out.println("一个回话创建成功");
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        //获取ServletContext()参数的在线人数
        Integer renshu = (Integer)se.getSession().getServletContext().getAttribute("renshu");
        Integer integer = --renshu;
        //从新设置ServletContext()参数的在线人数
        se.getSession().getServletContext().setAttribute("renshu",renshu);
        System.out.println("一个回话被销毁了");
    }


    @Override
    public void requestInitialized(ServletRequestEvent Initialized) {
        Integer 请求次数 =(Integer) Initialized.getServletContext().getAttribute("cishu");
        ++请求次数;
        Initialized.getServletContext().setAttribute("cishu",请求次数);
        System.out.println("request创建了一个请求");




    }

    @Override
    public void requestDestroyed(ServletRequestEvent Destroyed) {

        System.out.println("request销毁了一个请求");
    }
}
