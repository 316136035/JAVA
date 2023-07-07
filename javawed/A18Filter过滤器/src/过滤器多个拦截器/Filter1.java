package 过滤器多个拦截器;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class Filter1 implements Filter {
    public void destroy() {
        System.out.println("Filter1被销毁了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//         doFilter 谁先拦截了--前 谁就后放行
        System.out.println("Filter1被拦截了--前");
        chain.doFilter(req, resp);
        System.out.println("Filter1被放行了--后");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter1被创建了");
    }

}


/**
 Filter1被拦截了--前
 Filter2被拦截了---前
 Filter2被放行了--后
 Filter1被放行了--后
 * */