package vip.taoshenjia.A06_HttpServletResponse响应对象;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class A01_HttpServletResponse响应对象 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过响应对象response设置网页的响应内容
        resp.addHeader("key", "vlava");
        //通过响应对象response设置网页N秒后自动跳转到百度(不要使用ajax请求会不生效)
        //resp.addHeader("Refresh","5;URL=https://www.baidu.com/");
        //通过响应对象response设置网页的页面内容
        //resp.getWriter().write("<h1 >爱你!</h1>");
        //通过响应对象response设置网页的页面内容带换行
//       // resp.getWriter().print("使用response对象的sendRedirect()方法能够将网页重定向到还有一个页面。" +
//                "重定向支持将地址重定向到不同的主机上，这一点与转发不同。" +
//                " 在client浏览器上将会得到跳转后的地址，" +
//                "并又一次发送请求链接； " +
//                "用户能够从浏览器的地址栏中看到跳转后的地址； " +
//                "重定向操作后，request中的属性将会所有失效，并開始一个新的request对象");
        //发送状态码
        //  resp.sendError(404);
        //Response请求重定向可以请求到外网
        //resp.sendRedirect("https://www.jd.com/");
        //使用响应对象进行请求重定向302(注意中文问题)(不要使用ajax请求会不生效)
         resp.sendRedirect(req.getContextPath() + "/jsp/302.jsp");



         /**常见场景
          * 登陆成功后的Response请求重定向
          *
          * */



    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
