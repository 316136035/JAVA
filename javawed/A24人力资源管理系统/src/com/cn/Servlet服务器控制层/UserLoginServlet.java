package com.cn.Servlet服务器控制层;

import com.cn.Model实体类.User;
import com.cn.Service业务层.Service业务层实现.UserServiceimplements;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    /**注入一个Service业务层实现*/
    UserServiceimplements userServiceimplements = new UserServiceimplements();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台请求过来的参数(编码已经通过filter处理)
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Service业务层实现类→Dao持久层实现类(返回User对象)
        User user = userServiceimplements.getUser(username, password);
        //判断数据库是否有这个对象
        if (user !=null){
            //设置session
            request.getSession().setAttribute("user",user);

            //请求从定向（成功页面）
            request.getRequestDispatcher("jsp/综合案例.jsp").forward(request,response);

        }else {

            //请求从定向到登陆页面
            request.setAttribute("errorMsg","账号/密码错误");
            request.getRequestDispatcher("登陆页面.jsp").forward(request,response);


        }

    }
}
