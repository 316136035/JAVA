package A01过滤器配置xml文件和设置编码和生命周期和处理中文乱码问题;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter2注解方法创建" ,urlPatterns ="/Filter2注解方法创建" )
public class Filter2注解方法创建 implements Filter {
    public void destroy() {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2注解方法创建-----过滤器被执行了--前");

        chain.doFilter(req, resp);
        System.out.println("Filter2注解方法创建------过滤器被执行了--后前");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
