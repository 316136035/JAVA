package A03_UDP协议通信_无头通信.A02_UDP多线程协议通信_实现多线程通信;



import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class A02_UDP多线程协议通信Client implements Runnable {

    DatagramSocket datagramSocket = null;
    Scanner scanner = null;

    private int port;
    private String serverip;
    private int serverport;

    public A02_UDP多线程协议通信Client(int port, String serverip, int serverport) {
        this.port = port;
        this.serverip = serverip;
        this.serverport = serverport;
        /**创建一个扫描器*/
        scanner = new Scanner(System.in);
        try {
            /**创建无头通信数据报套接字*/
            datagramSocket = new DatagramSocket(this.port);

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                /**读取控制器数据*/
                String str = scanner.nextLine();
                /**跳出循环*/
                if (str.equals("ESC")) {
                    System.out.println("客户端已停用");
                    break;
                }
                /**字符串转字节数组*/
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                /**创建数据包(字节数组,字节数组开始索引,字节数组结束索引,对方ip,对方端口)*/
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.serverip, this.serverport));
                /**使用datagramSocket发送数据包*/
                this.datagramSocket.send(datagramPacket);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }

        }


    }



