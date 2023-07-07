import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Base64;

public class DengluServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置获取和响应编码(服务器9不用设置)
       request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
        //获取网页输入的内容
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //如果网页输入的内容是空的话 就判断cookie
        if (username.isEmpty() && password.isEmpty()) {
            String value = null;
            //获取网页的全部cookie
            Cookie[] cookies = request.getCookies();
            //如果(cookies不等于null 就遍历
            if (cookies != null) {
                //遍历cookie
                for (Cookie cookie : cookies) {
                    //如果cookie的key有等于cookie（表示有这个cookie 付给value）
                    if (cookie.getName().equals("cookie" )) {
                        value = cookie.getValue(); } } }
                        //cookie是空的话你还没有cookie登陆！！！！
            if (value!=null){
                System.out.println("欢迎使用cookie");
                //使用 BASE64解码
                value = new String( Base64.getDecoder().decode(value));
                //拆分解码后的字符串
                String[] split = value.split(":");
                //获取之前存放在服务器的session对象
                HttpSession session = request.getSession();
                String username1 =(String) session.getAttribute("username");
                String password1 = (String)session.getAttribute("password");
                //遍历拆分解码后的字符串 cookie
                for (int i = 0; i < split.length; i++) {
                    //判断解码后的字符串cookie 和session的字符串 对比是否相等
                    if (split[0].equals(username1) && split[1].equals(password1)) {
                        //相等的话
                       // response.getWriter().println("欢迎使用cookie" + "登陆成功");
                        request.getRequestDispatcher("WEB-INF/登陆成功页面/登陆成功.html").forward(request,response);
                        return;
                    }  }
            }
            if (value==null) {

                response.getWriter().println("你还没有cookie登陆/非法！！！！");
                return;

                //cookie不是空的话
            }
            //如果网页输入的内容不是空的话 就判断账号密码
        } else {
            if (username != null && password != null) {
                //如果账号密码是对的话
                if (username.equals("admin") && password.equals("admin")) {
                    //如果账号密码是对的话并选择的自动登陆的话
                    String che = request.getParameter("che");
                    if ("1".equals(che)) {
                        //把账号密码存放在session
                        HttpSession session = request.getSession();
                        session.setAttribute("username",username);
                        session.setAttribute("password",password);
                        //创建用户对象
                        UsernamePassword usernamePassword = new UsernamePassword(username, password);
                        String valve = usernamePassword.getUsername() + ":" + usernamePassword.getPassword();
                        //使用 BASE64加密
                        String encode = Base64.getEncoder().encodeToString(valve.getBytes());
                        //创建cookie
                        Cookie cookie = new Cookie("cookie", encode);
                        //把加密后的存放到网页的cookie
                        response.addCookie(cookie);
                       // response.getWriter().println("欢迎被" + username + "使用把加密后的存放到网页的cookie登陆成功");
                        request.getRequestDispatcher("WEB-INF/登陆成功页面/登陆成功.html").forward(request,response);

                    } else {
                        request.getRequestDispatcher("WEB-INF/登陆成功页面/登陆成功.html").forward(request,response);

                        //response.getWriter().println("欢迎" + username + "登陆成功");
                    }
                } else {
                    response.getWriter().println(" 账号/密码错误!!!!!");
                    return;
                }

            }


        }


    }
}
