package vip.tao.Spring_MyBatis_MVC_Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/RestFul")
public class RestFul {
    /**接受前台的请求方法Get*/
    @GetMapping(path = "/insert")
    public String insert(String name, Model model) {
        model.addAttribute("insert", "insert方法");
        return "RestFul";}
    /** 接受前台的请求方法Delete*/
    @DeleteMapping(path = "/delete")
    public String delete(Model model) {
        model.addAttribute("delete", "delete方法");
        return "RestFul";}
    /**接受前台的请求方法Post*/
    @PostMapping(path = "/uplete")
    public String uplete(Model model) {
        model.addAttribute("uplete", "uplete方法");
        return "RestFul";}
    /**|/路径/{获取前台传参},接受前台的请求方法*/
    @RequestMapping(path = "/select/{a}/{b}", method = RequestMethod.GET)
    public String select(@PathVariable int a, @PathVariable String b, Model model) {
        model.addAttribute("select", "select方法" + a + b);
        return "RestFul";}}
