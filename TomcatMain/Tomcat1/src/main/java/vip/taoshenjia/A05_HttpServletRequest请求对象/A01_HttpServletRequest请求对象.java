package vip.taoshenjia.A05_HttpServletRequest请求对象;

import javax.servlet.ServletException;
import javax.servlet.http.*;

;import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.BiConsumer;

public class A01_HttpServletRequest请求对象 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("获得上下文路径:"+req.getContextPath());
        System.out.println("获得作者信息:"+req.getAuthType());
        System.out.println("获取前台传来的url/date参数："+req.getParameter("username"));
        System.out.println("获取前台传来的cookies:"+Arrays.toString(req.getCookies()));
        System.out.println("获得请求路径:"+req.getHttpServletMapping().getServletName());
        System.out.println("获得请求的方法:"+req.getMethod());
        System.out.println("获得最后一次登录:"+req.getPathTranslated());
        System.out.println("获取远程的用户:"+req.getRemoteUser());
        System.out.println("获取请求网址:"+req.getRequestURL());
        System.out.println("获取Servlet路径:"+req.getServletPath());

        /**"获取前台传来的头信息Response Headers */
        Enumeration<String> headerNames = req.getHeaderNames();
        遍历枚举( req,headerNames  );
        /**放多个key相同会转成key对【数组}*/
        Map<String, String[]> parameterMap = req.getParameterMap();
        遍历Map(parameterMap);
        /**获取前台传来的url/date参数（多选框使用）*/
        String[] ches = req.getParameterValues("che");
        System.out.println("多选框使用:"+Arrays.toString(ches));


        req.setAttribute("key1", "valve1");
        req.setAttribute("key2", "valve2");
        req.setAttribute("key3", "valve3");

        /**HttpServletRequest请求转发地址栏是不会有变化的(把request,response也带过去了)_也可以请求转发到servlet
        也可以可以转发到WEB-INF安全文件下的html
        对于浏览器走一次请求*/
        req.getRequestDispatcher("/jsp/HttpServletRequest.jsp").forward(req,resp);

    }

    protected static void 遍历枚举(HttpServletRequest req,Enumeration<String> headerNames ){
        /**遍历遍历枚举头信息Response Headers*/
        while (headerNames.hasMoreElements()){
            /*获取全部Response Headers的key**/
            String key = headerNames.nextElement();
            /*获取全部Response Headers的valve*/
            String header = req.getHeader(key);
            System.out.println(key +header);
        }



    }
    protected static void 遍历Map(  Map<String, String[]> map){

        map.forEach(new BiConsumer<String, String[]>() {
              @Override
            public void accept(String s, String[] strings) {
                  System.out.println("获取前台传来的url/date参数:"+"   "+s+"   "+Arrays.toString(strings));
            }
        });



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
