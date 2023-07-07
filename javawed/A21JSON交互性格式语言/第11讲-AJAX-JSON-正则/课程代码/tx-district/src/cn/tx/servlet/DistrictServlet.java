package cn.tx.servlet;

import cn.tx.service.DistrictService;
import cn.tx.service.DistrictServiceImpl;
import com.alibaba.fastjson.JSONArray;

import java.io.IOException;

/**
 * @author Administrator
 * @title: ${NAME}
 * @projectName tx-district
 * @description: TODO
 * @date 2019/6/2422:05
 */
@javax.servlet.annotation.WebServlet(name = "DistrictServlet",urlPatterns = "/loadDistrict")
public class DistrictServlet extends javax.servlet.http.HttpServlet {
    // 创建一个Service对象
    DistrictService districtService = new DistrictServiceImpl();
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String spid = request.getParameter("pid");
        // 从service对象获取下级地区的集合
        JSONArray jsonArray = districtService.listDistrict(Integer.parseInt(spid));
        response.setCharacterEncoding("utf-8");
        // 设置响应类型为json
        response.setContentType("text/json;charset=utf-8");
        // 返回响应内容
        response.getWriter().write(jsonArray.toJSONString());
    }
}
