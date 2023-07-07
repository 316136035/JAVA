package com.cn.Servlet服务器控制层;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserLongFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {


        //把request强转为HttpServletRequest
        HttpServletRequest request1 = (HttpServletRequest) request;
        //获取RequestURI
        String requestURI = request1.getRequestURI();

        /**放行静态资源*/
        if(requestURI.contains("/")||requestURI.contains("/js/")||requestURI.contains("/css")
        ||requestURI.contains("/img/")){
            //放行
            chain.doFilter(request, response);

            return;
        }

        /**放行登陆请求*/
        if(requestURI.contains("/userLoginServlet")){
            //放行
             chain.doFilter(request, response);
            return;
        }
        /**放行退出登陆请求*/
        if(requestURI.contains("/UserExistServlet")){
            //放行
            chain.doFilter(request, response);
            return;
        }



        /**获取前台传过来的username是否是null*/
        Object username = request1.getSession().getAttribute("username");
        if (username==null){
            //请求从定向到登陆页面
            request.setAttribute("errorMsg","你还没有登陆");
            request.getRequestDispatcher("登陆页面.jsp").forward(request,response);
        }else {
            //放行
            chain.doFilter(request, response);
        }









    }
}
