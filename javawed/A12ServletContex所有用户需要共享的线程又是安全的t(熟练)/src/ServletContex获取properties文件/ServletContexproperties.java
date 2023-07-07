package ServletContex获取properties文件;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

@WebServlet(name = "ServletContexproperties" ,urlPatterns = "/ServletContexproperties")
public class ServletContexproperties extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/***这个是第一种方法*/
      ServletContext servletContext = getServletContext();
///**通过servletContext对象获取该文件的真实路径*/
        String realPath = servletContext.getRealPath("数据库连接池.properties");
        System.out.println(realPath);
   //     /**通过servletContext对象获取该文件编译后真实路径*/
       String realPath1 = servletContext.getRealPath("WEB-INF\\classes\\数据库连接池.properties");
       System.out.println(realPath1);
//        FileInputStream fileInputStream = new FileInputStream(new File(realPath));
        //通过servletContext对象获取该文件的真实路径
//        InputStream inputStream = servletContext.getResourceAsStream("\\WEB-INF\\classes\\数据库连接池.properties");
//        Properties properties1 = new Properties();
//        properties1.load(inputStream);
//        System.out.println(properties1.getProperty("jdbc.driver"));
//
        //这个是第二种方法
       // ServletContext servletContext = getServletContext();
        Properties properties = new Properties();
//        //通过反射
        InputStream inputStream1 = this.getClass().getClassLoader().getResourceAsStream("数据库连接池.properties");
        properties.load(inputStream1);
        System.out.println(properties.getProperty("jdbc.driver"));

        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            Object name = enumeration.nextElement();
            String property = properties.getProperty(name.toString());
            System.out.println(name +property);
        }


    }
}
