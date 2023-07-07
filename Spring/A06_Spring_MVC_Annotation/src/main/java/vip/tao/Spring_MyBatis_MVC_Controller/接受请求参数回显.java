package vip.tao.Spring_MyBatis_MVC_Controller;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vip.tao.Spring_MyBatis_MVC_Oom.User;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("for")
public class 接受请求参数回显 {
    @RequestMapping("/ward1")
    /**前台传参的名字不一样使用这个注解@RequestParam("username")*/
    public String 接受请求参数回显参数(@RequestParam("username") String name, Model model) {
        System.out.println("接受到前端参数：" + name);
        model.addAttribute("name", "接受到前端参数：" + name);
        // 转发不支持视图解释器
        return "RestFul";}
    @RequestMapping("/ward2")
    /**假设传递的是一个对象User，匹虎user对象中的字段名，如果名字一致则OK，否则，匹亮不到
     *前台传参的名字不一样使用这个注解@RequestParam("username")*/
    public String 接受请求参数回显对象(User user, Model model) {
        System.out.println("接受到前端参数：" + user);
        model.addAttribute("name", "接受到前端参数：" + user.toString());
        // 转发不支持视图解释器
        return "RestFul";}
    @RequestMapping("/ward3")
    /**Modelmap : 继承了LinkedHashMap，所以他拥有LinkedHashMap的全部功能!*/
    public String 使用ModelMap接受请求参数回显(@RequestParam("username") String name, ModelMap modelMap) {System.out.println("接受到前端参数：" + name);
        modelMap.addAttribute("modelMap",name);
        // 转发不支持视图解释器
        return "RestFul";}
    @RequestMapping("/ward4")
    /**Modelmap : 继承了LinkedHashMap，所以他拥有LinkedHashMap的全部功能!*/
    public String Json(Model model) {
       List<User> list = new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {list.add(new User(i,"周先生",20+1)) ;}
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
         model.addAttribute("list",jsonArray.toJSONString());
         // 转发不支持视图解释器
        return "RestFul";}}
