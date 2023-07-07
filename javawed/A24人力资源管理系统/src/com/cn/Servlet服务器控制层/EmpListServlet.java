package com.cn.Servlet服务器控制层;

import com.cn.Model实体类.Emp;
import com.cn.Service业务层.Service业务层实现.EmpServiceimplements;
import com.cn.Utils工具类.Page;
import com.cn.Utils工具类.RequestUtils格式转换;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class EmpListServlet extends HttpServlet {
    EmpServiceimplements empServiceimplements = new EmpServiceimplements();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受浏览器传达的全部参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        //创建HashMap(存放浏览器传达的全部参数)
        HashMap<String, Object> params = new HashMap<>();

        //格式转换( Map<String, String[]>转成HashMap)
        RequestUtils格式转换.copyProperties(params, parameterMap);

        // 调用service 获取分页对象
        Page<Emp> page = empServiceimplements.listEmp(params);
        // 向request作用域内存入数据
        request.setAttribute("page", page);
        request.setAttribute("name", params.get("name"));
        //转参用于下拉选择框
        request.setAttribute("district", "".equals(params.get("district"))? null : params.get("district"));



        request.getRequestDispatcher("jsp/员工管理.jsp").forward(request, response);


    }
}
