package vip.taoshenjia.A04_ServletContex所有用户需要共享的线程又是安全;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class A03_ServletContex获取xml配置的key和valve extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**--初始化参数 该参数可以在任意servlet中访问,获取ServletContext对象-->*/
        ServletContext servletContext = this.getServletContext();
        //获取xml的context-param的枚举集合
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        //遍历全部key
        while (initParameterNames.hasMoreElements()){
            //获取每一个key
            String key = initParameterNames.nextElement();
            //通过key获取每个valve
            String valve = servletContext.getInitParameter(key);

            resp.getWriter().print(key+"="+valve+"<br>");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
