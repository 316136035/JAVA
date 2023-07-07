package A01请求对象request;

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

@WebServlet(name = "A02获取get和post请求参数",urlPatterns = "/A02获取get和post请求参数")
public class A02获取get和post请求参数 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        //第一种方法通过枚举的方式
        //获取全部参数的key值
        System.out.println("枚举的方式获取全部参数的key单值");
        Enumeration<String> parameterNames = request.getParameterNames();
        //遍历枚举
        while (parameterNames.hasMoreElements()){
            //获取到每一个key
            String key= parameterNames.nextElement();
            //通过key获取valve
            String valve = request.getParameter(key);
            System.out.println(key+":"+valve);
        }


        /**获取到多选框选择的内容*/
        String[] likes = request.getParameterValues("like");
        System.out.println(Arrays.toString(likes));
        System.out.println("获取全部全部参数的key和valve");

        System.out.println("枚举的方式获取全部参数的key多值");
        //枚举的方式获取全部参数的key多值"
        Enumeration<String> parameterNames1 = request.getParameterNames();
        //遍历枚举的方式
        while (parameterNames1.hasMoreElements()){
            //获取到每一个key
            String key = parameterNames1.nextElement();
            //通过key获取多个值
            String[] parameterValues = request.getParameterValues(key);
            //打印
            System.out.println(Arrays.toString(parameterValues));

        }

        System.out.println("map集合的方式获取全部参数的key多值---------------------------------------------");
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  //获取全部参数的key值的枚举
        Enumeration<String> parameterNames = request.getParameterNames();
        //遍历枚举
        while (parameterNames.hasMoreElements()){
            //获取到每一个key
            String key = parameterNames.nextElement();
            //通过key获取valve
            String vale = request.getParameter(key);
            System.out.println(""+"     "+vale);

        }


    }
}
