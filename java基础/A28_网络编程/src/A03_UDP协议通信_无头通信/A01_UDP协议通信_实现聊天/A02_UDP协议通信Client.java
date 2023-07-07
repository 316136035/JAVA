package A03_UDP协议通信_无头通信.A01_UDP协议通信_实现聊天;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class A02_UDP协议通信Client {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            /**创建无头通信数据报套接字*/
            datagramSocket = new DatagramSocket(1234);

            /**请求的地址和端口*/
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);

            /**创建一个扫描器*/
            Scanner scanner = new Scanner(System.in);

            while (true) {
                /**读取控制器数据*/
                String str = scanner.nextLine();
                /**跳出循环*/
                if (str.equals("ESC")){
                    System.out.println("客户端已停用");
                    break;}
                /**字符串转字节数组*/
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                /**创建数据包(字节数组,字节数组开始索引,字节数组结束索引,对方ip,对方端口)*/
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,inetSocketAddress);
                /**使用datagramSocket发送数据包*/
                datagramSocket.send(datagramPacket);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (datagramSocket != null){
            datagramSocket.close();
        }
        }

    }
}
