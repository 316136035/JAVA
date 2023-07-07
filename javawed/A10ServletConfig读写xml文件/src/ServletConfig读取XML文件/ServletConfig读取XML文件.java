package ServletConfig读取XML文件;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfig读取XML文件 extends HttpServlet {

    @Override
    public void init() throws ServletException {

        //获取ServletConfig对象(只能获取当前的Srevlet的初始化参数)
        ServletConfig servletConfig = getServletConfig();
        //获取每一个 key对应的valve
        String password = servletConfig.getInitParameter("username");
        System.out.println(password);
        //获取所有初始化name的枚举集合
        Enumeration<String> Names = servletConfig.getInitParameterNames();
        //遍历枚举集合
        //如果有下一个元素的话就遍历
        while (Names.hasMoreElements()) {
            //获取每一个 key
            String key = Names.nextElement();
            //通过key获取到valve
            String valve = servletConfig.getInitParameter(key);
            System.out.println(key+"="+valve);


        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }


}
