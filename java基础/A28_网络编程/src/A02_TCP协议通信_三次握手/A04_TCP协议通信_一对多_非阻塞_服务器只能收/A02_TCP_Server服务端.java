package A02_TCP协议通信_三次握手.A04_TCP协议通信_一对多_非阻塞_服务器只能收;

import A02_TCP协议通信_三次握手.A03_TCP协议通信_一对一_非阻塞.A01_TCP通信ReaderRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.RejectedExecutionException;

public class A02_TCP_Server服务端 {
    public static void main(String[] args) {
        /**服务端**/
        System.out.println("====服务端=====");
        ServerSocket serverSocket=null;

        自定义线程池 自定义线程池 = new 自定义线程池(10,50,50,100);
        try {
            /**创建服务器套接字*/
            serverSocket = new ServerSocket(7777);


            while (true){

                /**阻塞监听*/
                Socket accept = serverSocket.accept();
                System.out.println(accept.getRemoteSocketAddress() + "已上线");

                /**启动读取的线程*/

                自定义线程池.execute(new A01_TCP通信ReaderRunnable(accept));

            }




        } catch (IOException e) {

            e.printStackTrace();
        }
        catch (RejectedExecutionException e) {
            System.out.println("服务器繁忙...");
        }finally {
            if (  serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
