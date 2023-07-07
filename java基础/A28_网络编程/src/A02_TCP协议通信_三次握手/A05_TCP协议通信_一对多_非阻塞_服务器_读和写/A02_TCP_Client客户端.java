package A02_TCP协议通信_三次握手.A05_TCP协议通信_一对多_非阻塞_服务器_读和写;

import java.io.IOException;
import java.net.Socket;

public class A02_TCP_Client客户端 {
    public static void main(String[] args) {

        /**客户端**/
        System.out.println("====客户端=====");
        Socket socket=null;
        try {
            /**Socket套接字*/
            socket = new Socket("127.0.0.1",7777);

            /**启动读取的线程*/

            new Thread(new A01_TCP通信_Reader_Runnable( socket )).start();
            /**启动写的线程*/

            new Thread(new A01_TCP通信_Writer__Runnable( socket )).start();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
