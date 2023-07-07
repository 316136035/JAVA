package vip.tao.Spring_MyBatis_MVC_Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller //允许交给组件扫描 控制器调度员
/**同等于http://localhost:9090/shen/*/
@RequestMapping("/shen")
//@RestController  设置不会交给视图解释器处理
public class MyController {
    /**同等于http://localhost:9090/shen/Controller1*/
    @RequestMapping(path = "/Controller1")
    public String Select(Model model) {
        model.addAttribute("esg1", "注解方式配置Spring_MVC");
        /**return 后的*/
        return "HelloController1";}
    /***同等于http://localhost:9090/shen/Controller1*/
    @RequestMapping(path = "/Controller2")
    /**ModelAndView存放到视图解释器  (参数request,response) */
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("esg2", "注解方式配置Spring_MVC");
        /**字符串会交给视图解释器处理*/
        modelAndView.setViewName("HelloController1");
        return modelAndView;
    }}
