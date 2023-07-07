package vip.taoshenjia.Filter;

import vip.taoshenjia.A04_Model实体类.User;
import vip.taoshenjia.Utils.Constants常量;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class A02_权限拦截  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  req = (HttpServletRequest) servletRequest;
        HttpServletResponse  resp = (HttpServletResponse) servletResponse;
        User user = (User) req.getSession().getAttribute(Constants常量.USER_SESSion);
        if (user  != null ){
            System.out.println(user.toString());
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println("没有权限重定向到登陆页面");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");

        }

        /**cookie登陆的权限还没有处理*/




    }
}
