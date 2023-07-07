package 过滤器多个拦截器;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class Filter2 implements Filter {
    public void destroy() {
        System.out.println("Filter2被销毁了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2被拦截了---前");
        chain.doFilter(req, resp);
        System.out.println("Filter2被放行了--后");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter2被创建了");
    }

}
