package A01请求对象request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "A01request获取请求头内容",urlPatterns = "/A01request获取请求头内容")
public class A01request获取请求头内容 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通过key获取IP地址和端口
        String hose = request.getHeader("Host");
        System.out.println(hose);

        //通过request获取到网页的请求头全部key
        Enumeration<String> headerNames = request.getHeaderNames();
        //遍历请求头全部key
        while (headerNames.hasMoreElements()){
            //获取请求头的每一个key
            String key = headerNames.nextElement();
            //通过每一个key获取到每一个valve
            String valve = request.getHeader(key);
            System.out.println(key+"    "+valve);

        }
        System.out.println("==============================================");
        System.out.println("request.getContentLength(): 正文数据长度：" + request.getContentLength());
        System.out.println("request.getContentType():正文数据类型： " + request.getContentType());
        System.out.println("request.getContextPath():项目路径名称： " + request.getContextPath());
        System.out.println("request.getMethod():请求类型： " + request.getMethod());
        System.out.println("request.getLocale(): 请求国家地址：" + request.getLocale());
        System.out.println("request.getQueryString(): URL请求过来带有连接拼接的内容：" + request.getQueryString());
        System.out.println("request.getRequestURI():项目路径名称后面的连接" + request.getRequestURI());
        System.out.println("request.getRequestURL(): 请求的网站连接" + request.getRequestURL());
        System.out.println("request.getServletPath():请求的路径 " + request.getServletPath());
        System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
        System.out.println("request.getRemoteHost(): " + request.getRemoteHost());
        System.out.println("request.getRemotePort(): " + request.getRemotePort());
        System.out.println("request.getScheme(): 请求的类型" + request.getScheme());
        System.out.println("request.getServerName()：请求的网址: " + request.getServerName());
        System.out.println("request.getServerPort(): 请求的网址的端口" + request.getServerPort());


    }
}
