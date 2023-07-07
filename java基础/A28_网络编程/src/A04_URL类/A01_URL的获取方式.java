package A04_URL类;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class A01_URL的获取方式 {
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        URL url = new URL("https://api.m.jd.com/client.action?functionId=newBabelAwardCollection&body={%22activityId%22:%22cef849c6281c45298b05c7a9a28e43c3%22,%22from%22:%22H5node%22,%22scene%22:%221%22,%22args%22:%22key=cef849c6281c45298b05c7a9a28e43c3,roleId=92396009%22}&client=wh5&clientVersion=1.0.0&area=&callback=jsonp2");
        /**获取*/
        System.out.println("获取协议https:"+url.getProtocol());
        System.out.println("获取主机IP/域名:"+url.getHost());
        System.out.println("获取端口:"+url.getPort());
        System.out.println("获取文件名:"+url.getPath());
        System.out.println("获取全路径:"+url.getFile());
        System.out.println("获取参数:"+url.getQuery());
        System.out.println("获取与此关联的协议的默认端口号URL:"+url.getDefaultPort());


        System.out.println(URLDecoder.decode(url.getQuery(), "UTF-8"));
        System.out.println(URLEncoder.encode(url.getQuery(), "UTF-8"));






    }
}
