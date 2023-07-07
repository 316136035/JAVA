package com.cn.Servlet服务器控制层;

import com.cn.Service业务层.Service业务层实现.EmpServiceimplements;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DelEmpServlet extends HttpServlet {
    EmpServiceimplements empServiceimplements = new EmpServiceimplements();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        empServiceimplements.DelEmp(id);
        // 跳转回列表页面


        response.sendRedirect("EmpListServlet");
    }


}
