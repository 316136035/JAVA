package A01_Server服务器;

import A03_Service业务层.JdServiceimplements;
import A04_实体类.Jd;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class JdlistServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int page = Integer.parseInt(request.getParameter("page"));
       int limit = Integer.parseInt(request.getParameter("limit"));
        JdServiceimplements jdServiceimplements = new JdServiceimplements();
        List<Jd> list_jd = jdServiceimplements.GetUserList(null,(page-1)*limit, limit);

        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list_jd);



        PrintWriter writer = response.getWriter();
        writer.write( jsonArray.toJSONString());
        writer.flush();








    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
