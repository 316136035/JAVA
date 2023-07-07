
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns = "/Servlet1")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //<%--request设置内容 ，当前请求有效--%>
        request.setAttribute("requestkey","requestvalve");
        //<%--Session设置内容 ，当前回话有效--%>
        request.getSession().setAttribute("sessionkey","sessionvalve");

        //servletContext设置内容服务器生命周期有效
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("ServletContextkey","ServletContextvalve");
        //Session设置内容
        request.getRequestDispatcher("A03jsp内置对象(精通).jsp").forward( request,response);



    }
}
