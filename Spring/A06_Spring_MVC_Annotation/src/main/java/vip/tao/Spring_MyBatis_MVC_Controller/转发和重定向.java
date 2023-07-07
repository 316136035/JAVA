package vip.tao.Spring_MyBatis_MVC_Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ForwardRedirect")
public class 转发和重定向 {
    @RequestMapping("/forward")
    public String forward(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("test","请求转发..");
        // 转发不支持视图解释器
        return "forward:/WEB-INF/jsp/RestFul.jsp";}
    @RequestMapping("/redirect")
    public String redirect(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("test","请求重定向 ..");
        return "redirect:https://order.jd.com/center/list.action";}}
