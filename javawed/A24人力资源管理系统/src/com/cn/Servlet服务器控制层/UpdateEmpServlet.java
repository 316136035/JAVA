package com.cn.Servlet服务器控制层;


import com.cn.Dao持久层操作数据库.Dao持久层实现.EmpDaoimplements;
import com.cn.Model实体类.Emp;
import com.cn.Utils工具类.RequestUtils格式转换;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class UpdateEmpServlet extends HttpServlet {
    //注入 EmpDaoimplements对象
    EmpDaoimplements empDaoimplements = new EmpDaoimplements();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Map<String, String[]> parameterMap = request.getParameterMap();
        Emp emp = new Emp();
        RequestUtils格式转换.copyProperties(emp,parameterMap);


        request.getRequestDispatcher("jsp/员工管理.jsp").forward(request, response);

    }
}
