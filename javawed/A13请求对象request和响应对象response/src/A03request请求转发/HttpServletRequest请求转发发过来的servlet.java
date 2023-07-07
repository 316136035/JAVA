package A03request请求转发;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "HttpServletRequest请求转发发过来的servlet" ,urlPatterns = "/HttpServletRequest请求转发发过来的servlet")
public class HttpServletRequest请求转发发过来的servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HttpServletRequest请求转发---跳转到-----求转发过来的servlet ");
        //获取 request作用域的内容
        Enumeration<String> attributeNames = request.getAttributeNames();
       while (attributeNames .hasMoreElements()){
           String key = attributeNames.nextElement();
           //通过key获取多个值
           String attribute = request.getAttribute(key).toString();
           System.out.println(key+" "+ attribute);


       }

       //获取通过网页传递过来并通过请求转发后的内容
        //map集合的方式获取全部参数的key多值
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历map集合
        //获取map的key数组
        Set<String> strings = parameterMap.keySet();
        //遍历key数据数组
        for (String key : strings) {
            //通过key获取到全部valve
            String[] strings1 = parameterMap.get(key);
            String string = Arrays.toString(strings1);
            System.out.println(key+":"+string );
        }

    }
}
