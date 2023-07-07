package com.cn.Servlet服务器控制层;

import com.cn.Dao持久层操作数据库.Dao持久层实现.EmpDaoimplements;
import com.cn.Model实体类.Emp;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SelectEmpServlet extends HttpServlet {
    //注入 EmpDaoimplements对象
    EmpDaoimplements empDaoimplements = new EmpDaoimplements();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Emp emp = empDaoimplements.selectEmp(id);
        System.out.println(emp);
        request.setAttribute("emp",emp);

        request.getRequestDispatcher("jsp/修改员工.jsp").forward(request,response);



    }
}
