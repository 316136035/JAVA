package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "A02cookie的获取", urlPatterns = "/A02cookie的获取")
public class A02cookie的获取 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //
        request.setCharacterEncoding("utf-8");
        //获取全部cookie
        Cookie[] cookies = request.getCookies();
        //遍历cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //获取到每一个cookie （获取他的key和valve）
               if (cookie.getName().equals("username")){
                   //解码
                   String username = URLDecoder.decode(cookie.getValue(), "UTF-8");

                   System.out.println("username"+"="+username);
               }
                //获取到每一个cookie （获取他的key和valve）
                if (cookie.getName().equals("password")){
                    //解码
                    String password = URLDecoder.decode(cookie.getValue(), "UTF-8");

                    System.out.println("password"+"="+password);
                }

            }
        }
    }
}
