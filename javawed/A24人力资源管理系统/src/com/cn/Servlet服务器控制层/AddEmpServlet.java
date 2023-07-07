package com.cn.Servlet服务器控制层;

import com.cn.Model实体类.Emp;
import com.cn.Service业务层.Service业务层实现.EmpServiceimplements;
import com.cn.Utils工具类.RequestUtils格式转换;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class AddEmpServlet extends HttpServlet {
    EmpServiceimplements empServiceimplements = new EmpServiceimplements();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受浏览器传达的全部参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        Emp emp = new Emp();

        RequestUtils格式转换.copyProperties(emp,parameterMap);


        System.out.println(emp);
        empServiceimplements.addEmp(emp);

        response.sendRedirect("EmpListServlet?pageCode=1&pageSize=25");


    }
}
