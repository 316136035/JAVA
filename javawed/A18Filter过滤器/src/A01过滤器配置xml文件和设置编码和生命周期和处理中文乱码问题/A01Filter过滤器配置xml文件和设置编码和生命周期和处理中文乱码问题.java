package A01过滤器配置xml文件和设置编码和生命周期和处理中文乱码问题;

import javax.servlet.*;

import java.io.IOException;
import java.util.Enumeration;


public class A01Filter过滤器配置xml文件和设置编码和生命周期和处理中文乱码问题 implements Filter {
    private String UTF;
    public void init(FilterConfig filterConfig) throws ServletException {

        /**获取xml的设置初始化参数-*/
        Enumeration<String> Names = filterConfig.getInitParameterNames();
        while (Names.hasMoreElements()){
            String name = Names.nextElement();
            String Parameter =  filterConfig.getInitParameter(name);
            System.out.println(name+"   "+Parameter);

        }
        //获取xml文件的Init
        UTF=  filterConfig.getInitParameter("UTF");


    }
    public void destroy() {
        System.out.println("Filter1摧毁过滤器");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding(this.UTF);
        resp.setCharacterEncoding(this.UTF);
        resp.setContentType("text/html;charSet="+this.UTF);



        System.out.println("Filter1-------过滤器被执行了");

           Boolean boolean1=true;
        if ( boolean1){
            //这个是放行的意思
            chain.doFilter(req, resp);
            System.out.println("Filter1-------过滤器被放行了");
            resp.getWriter().println("过滤器被放行了");


        }else {
            System.out.println("Filter1-------过滤器被拦截");
        }






    }



}
