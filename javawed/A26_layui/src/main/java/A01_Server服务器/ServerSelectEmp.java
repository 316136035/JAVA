package A01_Server服务器;

import A03_Service业务层.EmpServiceimplements;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServerSelectEmp extends HttpServlet {
    EmpServiceimplements empServiceimplements = new EmpServiceimplements();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(" ServletSelectEmp");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if (!StringUtils.isNullOrEmpty(page)&&!StringUtils.isNullOrEmpty(limit)){
            int count = empServiceimplements.Getcount();
            JSONObject Jsonemp = empServiceimplements.getEmp(Integer.parseInt(page), Integer.parseInt(limit));
            PrintWriter writer = response.getWriter();
            writer.write(Jsonemp.toJSONString() );
            writer.flush();
            writer.close();
        }
        if (StringUtils.isNullOrEmpty(page)&&StringUtils.isNullOrEmpty(limit)){
            JSONObject jsonObject = empServiceimplements.GetEmprole();
            PrintWriter writer = response.getWriter();
            System.out.println(jsonObject .toJSONString());
            writer.write(jsonObject .toJSONString() );
            writer.flush();
            writer.close();


        }






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
