package vip.tao.A01_Spring_xml配置_xml.controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import java.util.Enumeration;
import java.util.HashMap;
/**实现调度员接口*/
public  class HelloController1 implements Controller {
    @Override
    public ModelAndView handleRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();  //创建模型视图解释器*
        HashMap<String, String> hashMap = new HashMap<>();//创建集合
        Enumeration<String> headerNames = request.getHeaderNames();//获取全部名字
        //遍历集合
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            hashMap.put(name,request.getHeader(name)+"<br>");
        }
        //存放到视图解释器
        modelAndView.addObject("msg",hashMap+"前端IP:"+request.getRemoteAddr());
        //请求转发的页面名称
        modelAndView.setViewName("HelloController1");
        //返回模型视图视图解释器
        return modelAndView;
    }
}