package A01_InetAddress查看ip_inetSocketAddress套接字;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class A02_inetSocketAddress套接字就是ip加端口的对象 {
    public static void main(String[] args) {
        /**创建inetSocketAddress套接字*/
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
        /**获取端口*/
        System.out.println(inetSocketAddress.getPort());
        /**获取 InetAddress 对象*/
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address);




    }
}
