package A03request请求转发;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HttpServletRequest请求转发", urlPatterns = "/HttpServletRequest请求转发")
public class HttpServletRequest请求转发 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*HttpServletRequest请求转发地址栏是不会有变化的(把request,response也带过去了)_
也可以请求转发到servlet
也可以可以转发到WEB-INF安全文件下的html
对于浏览器走一次请求*/

        //tomcat9以上不用设置编码
//       request.setCharacterEncoding("UTF-8");
//       response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");

//向request作用域添加数据(它的作用范围小的多，它的范围只在一次请求响应范围之内)

        request.setAttribute("key1", "valve1");
        request.setAttribute("key2", "valve2");
        request.setAttribute("key3", "valve3");
        request.setAttribute("key4", "valve4");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        System.out.println("我是HttpServletRequest请求转发");
        // 下面是请求转发到Servlet服务器
        //request.getRequestDispatcher("HttpServletRequest请求转发发过来的servlet").forward(request,response);
        // 下面是请求转发到页面


        if (username != null & password != null) {
            if (username.equals("admin") & password.equals("admin")) {

                request.getRequestDispatcher("WEB-INF/登陆页面/登陆成功页面.html").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/登陆页面/登陆不成功页面.html").forward(request, response);

            }

        }



    }
}
