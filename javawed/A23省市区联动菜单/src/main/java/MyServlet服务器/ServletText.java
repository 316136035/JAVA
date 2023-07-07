package MyServlet服务器;

import Service业务层服务处理.DistrictServiceImpl;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletText extends HttpServlet {

    // 创建一个Service服务对象（用于执行SQL语句返回据库结果集的数据表并返回JSON格式）
    DistrictServiceImpl districtService = new DistrictServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取给请求过来的参数
        String spid = request.getParameter("pid");
        // 从service对象获取下级地区的集合（）
        JSONArray jsonArray = districtService.listDistrict(Integer.valueOf(spid));
        //设置响应字符编码
        response.setCharacterEncoding("utf-8");
        // 设置响应内容类型为json
        response.setContentType("text/json;charset=utf-8");
        // 返回响应内容
        response.getWriter().write(jsonArray.toJSONString());

    }



}
