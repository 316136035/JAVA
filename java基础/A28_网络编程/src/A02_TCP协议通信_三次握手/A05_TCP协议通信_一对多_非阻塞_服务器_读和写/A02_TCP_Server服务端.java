package A02_TCP协议通信_三次握手.A05_TCP协议通信_一对多_非阻塞_服务器_读和写;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.HashSet;

/**========服务端=========**/
public class A02_TCP_Server服务端 {
    /**存放在线人数的对象*/
public   static HashSet<    A01_TCP通信_Reader_Writer_Runnable> hashSet = new HashSet<>();
public static void main(String[] args) {
        /**服务端**/
        System.out.println("====服务端=====");
        ServerSocket serverSocket=null;
       try {
            /**创建服务器套接字*/
            serverSocket = new ServerSocket(7777);

            /**创建自定义线程池*/
            ThreadPoolExecutor自定义线程池 threadPoolExecutor = new ThreadPoolExecutor自定义线程池(10, 50, 50, 100);

            while (true){
                /**阻塞监听*/
                Socket accept = serverSocket.accept();
                System.out.println(accept.getRemoteSocketAddress() + "已上线");
                /**创建线程对象*/
                A01_TCP通信_Reader_Writer_Runnable a01_tcp通信_reader_writer_runnable = new A01_TCP通信_Reader_Writer_Runnable(accept);
                /**存入集合*/
                hashSet.add(a01_tcp通信_reader_writer_runnable);
                /**启动读取的线程*/
                threadPoolExecutor.execute(a01_tcp通信_reader_writer_runnable);
            }
       }

       catch (IOException e) {
           e.printStackTrace();
        } finally {
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
