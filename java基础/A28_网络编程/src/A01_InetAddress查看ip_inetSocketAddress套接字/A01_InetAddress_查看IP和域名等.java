package A01_InetAddress查看ip_inetSocketAddress套接字;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class A01_InetAddress_查看IP和域名等 {
    public static void main(String[] args) throws Exception {
        /**------------------------获取本地网络信息--------------------------*/
        System.out.println(InetAddress.getByName("127.0.0.1"));
        System.out.println("获取本地网络信息:"+InetAddress.getLocalHost());

        /**-------------------------查询外网IP地址-----------------*/
        InetAddress inetAddress = InetAddress.getByName("www.jd.com");
        System.out.println("查询外网域名和IP地址:"+inetAddress);
        /**获取外网ip*/
        System.out.println("获取外网ip:"+inetAddress.getHostAddress());
        /**获取外网域名*/
        System.out.println("获取外网域:"+inetAddress.getHostName());
        /**获取规范主机名*/
        System.out.println("获取规范主机名:"+inetAddress.getCanonicalHostName());

        InetSocketAddress inetSocketAddress = new InetSocketAddress(88);


    }
}
