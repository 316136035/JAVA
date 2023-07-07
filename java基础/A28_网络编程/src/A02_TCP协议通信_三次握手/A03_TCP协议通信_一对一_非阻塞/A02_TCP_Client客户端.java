package A02_TCP协议通信_三次握手.A03_TCP协议通信_一对一_非阻塞;

import A02_TCP协议通信_三次握手.A04_TCP协议通信_一对多_非阻塞_服务器只能收.A01_TCP通信WriterRunnable;

import java.io.IOException;
import java.net.Socket;

public class A02_TCP_Client客户端 {
    public static void main(String[] args) {

        /**客户端**/
        System.out.println("====客户端=====");
        try {
            Socket socket = new Socket("127.0.0.1",7777);

            /**启动读取的线程*/
            new Thread(new A01_TCP通信ReaderRunnable(socket)).start();
            /**启动写的线程*/
            new Thread(new A01_TCP通信WriterRunnable(socket)).start();





        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
