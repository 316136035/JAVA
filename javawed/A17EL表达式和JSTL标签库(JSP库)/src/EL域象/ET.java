package EL域象;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ET域隐藏对象" ,urlPatterns = "/ET域对象")
public class ET extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("111111111111111"
        );
        //设置获取和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        request.setAttribute("request","request域对象");
        request.getSession().setAttribute("Session","Session域对象");
        getServletContext().setAttribute("ServletContext","ServletContext域对象");
        request.getRequestDispatcher("EL表达式/A05域对象(精通）.jsp").forward(request,  response);



    }
}
