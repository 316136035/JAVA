package vip.taoshenjia.A01_Servler服务器.Role角色Servlet;

import vip.taoshenjia.A03_Service业务层.Role角色Service.A01_RoleServiceimplements;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class A01_RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        A01_RoleServiceimplements A01_RoleServiceimplements = new A01_RoleServiceimplements();
        String JSONString = A01_RoleServiceimplements.GetRoleList();
       // System.out.println(JSONString);
        PrintWriter writer = resp.getWriter();
        writer.write(JSONString );
        writer.flush();
        writer.close();



    }
}
