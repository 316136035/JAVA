package vip.taoshenjia.A01_Servler服务器.User登陆_退出_修改;

import vip.taoshenjia.A03_Service业务层.UserLoginService.A01_LoginServiceimplements;
import vip.taoshenjia.A04_Model实体类.User;
import vip.taoshenjia.Utils.Constants常量;
import vip.taoshenjia.Utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class A01_LoginServlet登陆 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /**获取前端传参*/
        String userCode = req.getParameter("userCode");
        String password = req.getParameter("password");
        String che = req.getParameter("che");
        HttpSession session = req.getSession();/**获取session回话*/
        /**判断前台传参是否为空(不为空查询数据库)*/
        if (!userCode.isEmpty() && !password.isEmpty()) {
            /**创建Service业务层对象*/
            A01_LoginServiceimplements a01_loginService登陆implements = new A01_LoginServiceimplements();
            /**调用Service业务层方法（获取数据库用户对象）*/
            User user = a01_loginService登陆implements.LoginService(userCode, password);
            /**判断前台传参是否和数据库用户对象相等*/
            if (userCode.equals(user.getUserCode()) && password.equals(user.getUserPassword())) {
                /**把用户对象的userCode 存放在session回话*/
                session.setAttribute(Constants常量.USER_SESSion, user);
                /**判断前端是否选择自动登陆*/
                if ("on".equals(che)) {
                    /**获取用户密码*/
                    String userPassword = user.getUserPassword();
                    /**用户密码使用MD5加密*/
                    String MD5userPassword = MD5Utils.encrypt(userPassword);
                    /**字符串拼接*/
                    String cookieString = user.getUserCode() + ":" + MD5userPassword;
                    /**用户账号和用户密码存放到cookie*/
                    Cookie cookie = new Cookie(Constants常量.user_cookies, cookieString);
                    cookie.setMaxAge(60*60*24);
                    resp.addCookie(cookie);
                }
                /**请求从定向到登陆成功页面*/
                resp.sendRedirect(req.getContextPath() + "/jsp/welcome.jsp");

            } else {
                req.setAttribute("error", "账号/密码不正确");
                /**请求转发到登陆页面*/
                req.getRequestDispatcher("/login.jsp").forward(req, resp);

            }

            /**判断前台传参是否为空(为空使用cookie登陆)*/
        }
//        else {
//            System.out.println("使用cookie登陆");
//            /**获取前端cookie*/
//            Cookie[] cookies = req.getCookies();
//            String value = null;
//            /**cookie不是空*/
//            if (cookies != null) {
//                /**遍历cookies*/
//                for (int i = 0; i < cookies.length; i++) {
//                    /**获取cookie的key*/
//                    Cookie cookie = cookies[i];
//                    System.out.println(cookie.getName()+"="+cookie.getValue());
//                    /**判断cookie的key是否为之前存进去的user_session*/
//                    if (cookie.getName().equals(Constants常量.user_cookies)) {
//                        /**获取成功（key.valve）*/
//                        value = cookie.getValue();}}
//                /**判断 cookie.getValue()*/
//                if (value != null&&!value.isEmpty()) {
//                    /**字符串拆分*/
//                    String[] split = value.split(":");
//                    /**获取cookie的key*/
//                    String userCode1 = split[0];
//                    /**获取cookie的valve*/
//                    String MD5userPassword1 = split[1];
//                    /**创建Service业务层对象*/
//                    A01_LoginService登陆implements a01_loginService登陆implements = new A01_LoginService登陆implements();
//                    /**调用Service业务层方法（获取数据库用户对象）*/
//                    User user = a01_loginService登陆implements.LoginService(userCode1, null);
//                    /**获取userPassword */
//                    String userPassword = user.getUserPassword();
//                    /**用户密码使用MD5加密*/
//                    String MD5userPassword2 = MD5Utils.encrypt(userPassword);
//                    /**判断前端和数据库的用户对象比较*/
//                    if (userCode1.equals(user.getUserCode()) && MD5userPassword1.equals(MD5userPassword2)) {
//                        /**把用户对象的userCode 存放在session回话*/
//                        session.setAttribute("userCode", user.getUserCode());
//                        /**请求从定向到登陆成功页面*/
//                        resp.sendRedirect(req.getContextPath() + "/jsp/welcome.jsp");
//                    } else {
//                        req.setAttribute("error", "你还没有登陆");
//                        req.getRequestDispatcher("/login.jsp").forward(req, resp);
//                        return;
//                    }
//                }
//                if (value==null||value.isEmpty()) {
//                    req.setAttribute("error", "你还没有登陆");
//                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
//                    return;
//                }
//
//            } else {
//                req.setAttribute("error", "你还没有登陆");
//                req.getRequestDispatcher("/login.jsp").forward(req, resp);
//                return;
//
//            }
//
//
//        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
