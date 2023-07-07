package vip.taoshenjia.A08_Session会话;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class A01_Session会话 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

     /** 。保存一个登录用户的信息
    。购物车信息;
    。在整个网站中经常会使用的数据，我们将它保存在Session中*/

        /**session创建的时候会操作Cookie*/
        /**服务器会给每一个用户 (浏览器) 创建一个Seesion对象;
         一个Seesion独占一个浏览器，只要浏览器没有关闭，这个Session就存在;。
         用户登录之后，整个网站它都可以访问!
         保存用户的信息;保存购物车的信息....*/
        //获取session对象
        HttpSession session = req.getSession();

        //向session内存入内容
        session.setAttribute("key", "valve");
        //向session内存入对象
        session.setAttribute("user", new usre(username,password ));
        //session.removeAttribute(user);

        /**设置session默认失效时间 请去xml文件配置*/



        /**判断session是否为新*/
        if (session.isNew()) {

            resp.getWriter().write("session创建成功..");
        } else {
            resp.getWriter().write("session已经存在...");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
