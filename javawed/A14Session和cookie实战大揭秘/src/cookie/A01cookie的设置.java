package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = " A01cookie的设置", urlPatterns = "/A01cookie的设置")
public class A01cookie的设置 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先转编码
        request.setCharacterEncoding("utf-8");
        //通过key获取指定valve
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //创建cookie（把获取的 username+password 当做cookie）（URLEncoder.encode(username,"UTF-8")中文加密）
        Cookie cookieusername = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
        Cookie cookiepassword = new Cookie("password", URLEncoder.encode(password,"UTF-8"));


        /*cookie.setMaxAge(60*60)：表示cookie对象可存活1小时。就算关闭浏览器，就算重启客户端电脑，cookie也会存活1小时。因为当maxAge大于0时，浏览器不仅会把cookie保存在浏览器内存中，还会把cookie保存到硬盘上。
        cookie.setMaxAge(-1)：cookie的maxAge属性的默认值就是-1（其实只要是负数都是一个意思），表示只在浏览器内存中存活。一旦关闭浏览器窗口，那么cookie就会消失。
          cookie.setMaxAge(0)：cookie被作废！表示cookie即不在内存中存活，也不在硬盘上存活，这样的cookie设置只有一个目的，那就是覆盖客户端原来的这个cookie，使其作废。*/
        //设置cooike存活时间1年
        cookieusername.setMaxAge(60 * 60 *24*365);
        //设置cooike路径
        cookieusername.setPath("/");
        //响应cooike给网页cooike
        response.addCookie(cookieusername);
        response.addCookie(cookiepassword);



    }
}
