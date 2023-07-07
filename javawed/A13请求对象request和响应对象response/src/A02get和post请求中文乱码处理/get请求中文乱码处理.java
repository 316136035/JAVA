package A02get和post请求中文乱码处理;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


@WebServlet(name = "get请求中文乱码处理" ,urlPatterns = "/get请求中文乱码处理")
public class get请求中文乱码处理 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 第二种方法,直接设置request，response的编码格式首选 （一定要放第一行）
       request.setCharacterEncoding("utf-8");
        String characterEncoding = request.getCharacterEncoding();
        System.out.println("获取编码"+characterEncoding);
        //通过request获取到参数的键值对map集合
        Map<String, String[]> parameterMap1 = request.getParameterMap();
        //遍历map集合  获取map的全部key
        Set<String> keys1 = parameterMap1.keySet();
        //遍历全部key
        for (String key : keys1) {
            //通过key获取到全部valves
            String[] Values = request.getParameterValues(key);
            System.out.println(key +":"+ Arrays.toString(Values));


        }

    }
}
