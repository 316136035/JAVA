package A03_UDP协议通信_无头通信.A01_UDP协议通信_实现聊天;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class A01_UDP协议通信Server {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            /**创建无头通信数据报套接字*/
            datagramSocket = new DatagramSocket(8888);


            /**定义字节数据*/
            byte[] bytes = new byte[1024];
            /**定义数据包*/
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            while (true) {
                /**阻塞接受义数据包*/
                datagramSocket.receive(datagramPacket);
                /**数组转字符串*/
                String str = new String(bytes, 0, bytes.length);
                System.out.println("数据包来源:" + datagramPacket.getAddress() + str);
                /**跳出循环*/
                if (str.equals("ESC")){
                    System.out.println("服务器已停用");
                    break;}
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if ( datagramSocket != null){ datagramSocket.close();}
        }

    }
}
