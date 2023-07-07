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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Servlet_Add_Delete_Update_Emp extends HttpServlet {
    EmpServiceimplements empServiceimplements = new EmpServiceimplements();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("Servlet_Add_Delete_Update_Emp");

        System.out.println("Servlet_Add_Delete_Update_Emp:"+name);
        if (!StringUtils.isNullOrEmpty("Servlet_Add_Delete_Update_Emp")){
            if (name.equals("Add")){Add_Emp( request, response);}
            if (name.equals("Delete")){Delete_Emp(request,response);}
            if (name.equals("Update")){Update_Emp( request, response);}



        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }


    protected  void  Add_Emp(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String date = request.getParameter("date");
        String deptid = request.getParameter("deptid");
        if (!StringUtils.isNullOrEmpty(id)&&
                !StringUtils.isNullOrEmpty(name)&&
                !StringUtils.isNullOrEmpty(age)&&
                !StringUtils.isNullOrEmpty(sex)&&
                !StringUtils.isNullOrEmpty(date)&&
                !StringUtils.isNullOrEmpty(deptid)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedate=null;
            try {parsedate = simpleDateFormat.parse(date);} catch (ParseException e) {e.printStackTrace();}
            JSONObject jsonObject = empServiceimplements.addEmp(
                    Integer.valueOf(id).intValue(),
                    name,
                    Integer.valueOf(age).intValue(),
                    Integer.valueOf(sex).intValue(),
                    new java.sql.Date(parsedate.getTime()),
                    Integer.valueOf(deptid).intValue()


            );
            try {
                PrintWriter writer = response.getWriter();
                writer.write(jsonObject.toJSONString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    protected  void  Delete_Emp(HttpServletRequest request, HttpServletResponse response){
        String empid = request.getParameter("empid");
        if (!StringUtils.isNullOrEmpty(empid)){
            int intempid = Integer.valueOf(empid).intValue();
            JSONObject jsonObject = empServiceimplements.deleteEmp(intempid);
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write(jsonObject.toJSONString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
    protected  void  Update_Emp(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String date = request.getParameter("date");
        String deptid = request.getParameter("deptid");

        if (!StringUtils.isNullOrEmpty(id)&&
                !StringUtils.isNullOrEmpty(name)&&
                !StringUtils.isNullOrEmpty(age)&&
                !StringUtils.isNullOrEmpty(sex)&&
                !StringUtils.isNullOrEmpty(date)&&
                !StringUtils.isNullOrEmpty(deptid)){


        }{
            Date parsedate=null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {parsedate = simpleDateFormat.parse(date);} catch (ParseException e) {e.printStackTrace();}
            JSONObject jsonObject = empServiceimplements.upDateEmp(
                    Integer.valueOf(id).intValue(),
                    name,
                    Integer.valueOf(age).intValue(),
                    Integer.valueOf(sex).intValue(),
                    new java.sql.Date(parsedate.getTime()),
                    Integer.valueOf(deptid).intValue()

            );

            try {
                PrintWriter writer = response.getWriter();
                writer.write(jsonObject.toJSONString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}
