package A03_UDP协议通信_无头通信.A02_UDP多线程协议通信_实现多线程通信;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class A01_UDP多线程协议通信Server  implements  Runnable{
    /**创建无头通信数据报套接字*/
    DatagramSocket datagramSocket ;

    private   String name;
   private int serverport;
    public    A01_UDP多线程协议通信Server( int serverport){
        try {
            this.serverport=serverport;

            datagramSocket = new DatagramSocket(serverport); ;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            /**创建无头通信数据报套接字*/

            /**定义字节数据*/
            byte[] bytes = new byte[1024];
            /**定义数据包*/
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            while (true) {
                /**阻塞接受义数据包*/
                datagramSocket.receive(datagramPacket);
                /**数组转字符串*/
                String str = new String(bytes, 0, bytes.length);
                System.out.println("数据包来源:" +"    "+ str);
                /**跳出循环*/
                if (str.equals("ESC")){
                    System.out.println("服务器已停用");
                    break;}}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
