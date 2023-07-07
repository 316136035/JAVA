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

@WebServlet(name = "post请求中文乱码处理" ,urlPatterns = "/post请求中文乱码处理")
public class post请求中文乱码处理 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request,  response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //打印默认编码（null表示使用工so-8859-1编码;）
        System.out.println(request.getCharacterEncoding());

/**对于每个请求，只需要调用request的setCharacterEncodng()一次，
然后所有getParameter()都会使用这个编码来解读参数。
但要注意，只对请求正文有效，即POST参数。*/

     /*   //第一种方法,针对字符串本身进行手动转码:首不选
        //通过request获取到参数的键值对map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历map集合  获取map的全部key
        Set<String> keys = parameterMap.keySet();
        //遍历全部key
        for (String key : keys) {
            //通过key获取到全部valves
            String[] Values = request.getParameterValues(key);
           // 遍历全部keyvalves
            for (String value : Values) {
                //针对字符串本身进行手动转码:
                String val = new String(value.getBytes("ISO-8859-1"), "utf-8");
                System.out.println(key+":"+val );
            }

        }*/
        // 第二种方法,直接设置request的编码格式首选 （一定要放第一行）
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
            System.out.println(key +":"+Arrays.toString(Values));


        }


    }
}
