package vip.taoshenjia.A04_ServletContex所有用户需要共享的线程又是安全;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class A01_ServletContex存储 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**存储Attribute参数*/
        this.getServletContext().setAttribute("key1", "valve1");
        this.getServletContext().setAttribute("key2", "valve2");
        this.getServletContext().setAttribute("key3", "valve3");
        resp.getWriter().print("ServletContext存储数据成功...");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
