package ServletContex的API;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletContex的API",urlPatterns = "/ServletContex的API")
public class ServletServletContexAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        其他发方法查看api javaee
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext.getContextPath());
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();


    }


    }
