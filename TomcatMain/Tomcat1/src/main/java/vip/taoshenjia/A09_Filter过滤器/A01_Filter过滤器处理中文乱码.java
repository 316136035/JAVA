package vip.taoshenjia.A09_Filter过滤器;


import javax.servlet.*;
import java.io.IOException;

public class A01_Filter过滤器处理中文乱码 implements Filter {
    @Override
    public void doFilter(ServletRequest  req, ServletResponse  resp, FilterChain filterChain) throws IOException, ServletException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //System.out.println("Filter1-------过滤器被执行了");
        Boolean boolean1=true;
        if (boolean1){
            //这个是放行的意思
            filterChain.doFilter(req, resp);
        //    System.out.println("Filter1-------过滤器被放行了");

        }else {
          //  System.out.println("Filter1-------过滤器被拦截");
        }



    }


}
