package com.cn.Servlet服务器控制层;


import com.alibaba.fastjson.JSONArray;
import com.cn.Service业务层.Service业务层实现.DistrictServiceimplements;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DistrictServle extends HttpServlet {
    com.cn.Service业务层.Service业务层实现.DistrictServiceimplements DistrictServiceimplements = new DistrictServiceimplements();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取给请求过来的参数
        String pid = request.getParameter("pid");
        // 从service对象获取下级地区的集合（）
        JSONArray addressjson = DistrictServiceimplements.getaddress(pid);
        //设置响应字符编码
        response.setCharacterEncoding("utf-8");
        // 设置响应内容类型为json
        response.setContentType("text/json;charset=utf-8");

        // 返回响应内容
        response.getWriter().write(addressjson.toJSONString());



    }


}
