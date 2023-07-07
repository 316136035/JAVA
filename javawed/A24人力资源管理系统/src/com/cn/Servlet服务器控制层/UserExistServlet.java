package com.cn.Servlet服务器控制层;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserExistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除session
        request.getSession().invalidate();
        //请求转发到登陆页面.jsp
        response.sendRedirect("/登陆页面.jsp");
    }


}
