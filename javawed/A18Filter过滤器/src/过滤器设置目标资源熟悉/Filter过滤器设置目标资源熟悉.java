package 过滤器设置目标资源熟悉;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class Filter过滤器设置目标资源熟悉 implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("Filter过滤器设置目标资源熟悉被销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter过滤器设置目标资源熟悉开始拦截");
        chain.doFilter(req, resp);
        System.out.println("Filter过滤器设置目标资源熟悉放行");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter过滤器设置目标资源熟悉启动");
    }

}
