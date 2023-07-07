package vip.taoshenjia.A01_Servler服务器.User用户管理;

import vip.taoshenjia.A03_Service业务层.User管理Service.A01_UserServiceimplements;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class A02_DaleUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String arr = req.getParameter("arr");
        String[] split = arr.split(",");
        A01_UserServiceimplements a01_userServiceimplements = new A01_UserServiceimplements();
        long l = a01_userServiceimplements.DeleUserService(split);
        System.out.println("A02_DaleUserServlet");




        resp.sendRedirect("/A01_UserServlet");






    }
}
