package Servlet的方法使用;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**YouServlet创建的Servlet名字, urlPatterns =url请求的网址的路径-->*/
@WebServlet(name = "YouServlet",urlPatterns = "/YouServlet")
public class A03YouServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("idera创建HttpServletA03YouServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
