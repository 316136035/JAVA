package vip.taoshenjia.A01_Servler服务器.User用户管理;

import com.mysql.cj.util.StringUtils;
import vip.taoshenjia.A03_Service业务层.User管理Service.A01_UserServiceimplements;
import vip.taoshenjia.A04_Model实体类.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class A01_UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**获取文本输入框*/
        String text = req.getParameter("text");
        System.out.println(text);
        /**获取角色id*/
        String userRole = req.getParameter("userRole");
        int intuserRole=0;
        if (StringUtils.isNullOrEmpty(userRole)){intuserRole=0;}
        if (!StringUtils.isNullOrEmpty(userRole)){intuserRole=Integer.parseInt(userRole);}

        /**获取当前页面*/
        String pageNo = req.getParameter("pageNo");
        int intpageNo=0;
        if (StringUtils.isNullOrEmpty(userRole)){intpageNo=0;;}
        if (!StringUtils.isNullOrEmpty(userRole)){intpageNo=Integer.parseInt(pageNo);}



        /**获取分页数量*/
        String pageSize = req.getParameter("pageSize");
        int intpageSize=5;
        if (StringUtils.isNullOrEmpty(userRole)){intpageSize=5;}
        if (!StringUtils.isNullOrEmpty(userRole)){intpageSize=Integer.parseInt(pageSize);}




        System.out.println("文本输入框"+text+"   "+"获取角色id"+userRole+"   "+"当前页面"+pageNo+"   "+"分页数量"+pageSize);

        A01_UserServiceimplements a01_userServiceimplements = new A01_UserServiceimplements();
        long count = a01_userServiceimplements.GetCount(text, intuserRole);
        List<User> userlist = a01_userServiceimplements.GetUserList(text, intuserRole, intpageNo, intpageSize);

        req.setAttribute("pageNo",pageNo);
        req.setAttribute("countpage",(count/intpageSize)+1);
        req.setAttribute("count",count);
        req.setAttribute("userlist",userlist);
        req.getRequestDispatcher("/jsp/StaffManagement/StaffManagement.jsp").forward(req,resp);



    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost( req, resp);
    }
}
