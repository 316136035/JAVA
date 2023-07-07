package vip.taoshenjia.A01_Servler服务器.User登陆_退出_修改;

import vip.taoshenjia.Utils.Constants常量;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class A02_ExistServlet退出 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(Constants常量.USER_SESSion);

        req.setAttribute("error", "退出登陆..");

//        for (Cookie cookie : req.getCookies()) {
//            if (cookie.getName().equals(Constants常量.user_cookies)) {
//                resp.addCookie(new Cookie(Constants常量.user_cookies, null));
//
//            }
//        }


        /**请求转发到登陆页面*/
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
