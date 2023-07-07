package ServletContex获取xml配置的key和valve;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletContex获取xml配置的key和valve" ,urlPatterns = "/ServletContex获取xml配置的key和valve")
public class ServletContexxmlkeyvalve extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /**--初始化参数 该参数可以在任意servlet中访问-->*/
        //获取ServletContext对象
        ServletContext servletContext = getServletContext();
        //获取xml的context-param的枚举集合全部key
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        //遍历全部key
        while (initParameterNames.hasMoreElements()){
            //获取每一个key
            String key = initParameterNames.nextElement();
            //通过key获取每个valve
            String valve = servletContext.getInitParameter(key);
            System.out.println(key +"   "+valve);

        }

    }
}
