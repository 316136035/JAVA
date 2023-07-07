package Servlet的方法使用;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/***继承HttpServlet 只能处理Http的请求*/
public class A02HttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.doPost( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet( request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("A02HttpServlet");
    }
}
