package Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class A01 {
    public static void main(String[] args) throws IOException {
        A01 test = new  A01();
        test.getpath();
    }
    public void getpath() throws IOException{
        String path = "";

        // 第1种：获取类加载的根路径
        path = this.getClass().getResource("/").getPath();
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);


//        // 第2种：获取当前类的所在工程路径,不加“/”  获取当前类的加载目录
        String decode = URLDecoder.decode(path, "UTF-8");
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);

//        // 第3种：获取项目路径
        File file = new File("");
        path = file.getCanonicalPath();
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);

//
//        // 第4种：获取当前运行的路径
        URL path1 = this.getClass().getResource("");
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);
//
//        // 第5种：获取项目路径path = System.getProperty("user.dir");
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);
//
//        // 第6种：获取当前运行的路径
        path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        path = URLDecoder.decode(path, "UTF-8");
        System.out.println(path);


        // 第7种：表示到项目的根目录下, 要是想到目录下的子文件夹,修改"/"即可
//        request.getSession().getServletContext().getRealPath("/");
        return;
    }
}
