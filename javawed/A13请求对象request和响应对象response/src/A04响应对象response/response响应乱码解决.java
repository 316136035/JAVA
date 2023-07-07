package A04响应对象response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "response响应乱码解决",urlPatterns = "/response响应乱码解决")
public class response响应乱码解决 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的格式和编码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        for (int i = 0; i <50 ; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.getWriter().println("我是中国人呢！！！<br>");
            }
    }
}
