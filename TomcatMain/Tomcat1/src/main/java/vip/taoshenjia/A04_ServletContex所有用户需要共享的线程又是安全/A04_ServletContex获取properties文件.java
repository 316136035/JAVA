package vip.taoshenjia.A04_ServletContex所有用户需要共享的线程又是安全;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class A04_ServletContex获取properties文件 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /**这个是第一种方法*/
        // ServletContext servletContext = getServletContext();
        Properties properties = new Properties();
        //通过反射获取资源流
        InputStream inputStream1 = this.getClass().getClassLoader().getResourceAsStream("druid.properties");
        //读取资源流
        properties.load(inputStream1);
        /*获取 properties 枚举对象*/
        Enumeration<?> enumeration = properties.propertyNames();
        /*遍历枚举对象*/
        while (enumeration.hasMoreElements()){
            String key= (String) enumeration.nextElement();
            String valve = properties.getProperty(key);
            System.out.println(key +valve );
            resp.getWriter().print(key+"="+valve+"<br>");
        }


        /***这个是第二种方法*/
//        ServletContext servletContext = getServletContext();
//        /**通过servletContext对象获取该文件的真实路径*/
//        String realPath = servletContext.getRealPath("数据库连接池.properties");
//        System.out.println(realPath);
//         /**通过servletContext对象获取该文件编译后真实路径*/
//        String realPath1 = servletContext.getRealPath("WEB-INF\\classes\\数据库连接池.properties");
//        System.out.println(realPath1);
//        FileInputStream fileInputStream = new FileInputStream(new File(realPath));
//        /**通过servletContext对象获取该文件的真实路径*/
//        InputStream inputStream = servletContext.getResourceAsStream("\\WEB-INF\\classes\\数据库连接池.properties");
//        Properties properties1 = new Properties();
//        properties1.load(inputStream);
//        System.out.println(properties1.getProperty("jdbc.driver"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,  resp);
    }
}
