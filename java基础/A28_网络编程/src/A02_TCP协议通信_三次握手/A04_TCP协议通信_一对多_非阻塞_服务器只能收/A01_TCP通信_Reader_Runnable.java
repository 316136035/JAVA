package A02_TCP协议通信_三次握手.A04_TCP协议通信_一对多_非阻塞_服务器只能收;

import A02_TCP协议通信_三次握手.A05_TCP协议通信_一对多_非阻塞_服务器_读和写.CloseUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端读取的线程
 **/
public class A01_TCP通信_Reader_Runnable implements Runnable {
    /**Socket套接字*/
    private Socket socket;
    /**输入流*/
    private  BufferedReader bufferedReader = null;
    /**定义是否可以读取的变量*/
    private boolean flag = true;

    /***构造器*/
    public A01_TCP通信_Reader_Runnable(Socket socket) {
        /**传入Socket套接字*/
        this.socket=socket;
        try {
            /**获取并构造器创建输入流**/
            bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (IOException e) {
            /**出现异常变量付false*/
            flag = false;
            /**关闭输入流*/
            CloseUtil.closeAll(bufferedReader);
        }


    }

    public String Reader() {
        String str = "";
        try {
            /**使用输入流读取每一行*/
            str = bufferedReader.readLine();
        } catch (IOException e) {
            /**出现异常变量付false*/
            flag = false;
            /**关闭输入流*/
            CloseUtil.closeAll(bufferedReader);
        }
        return str;
    }

    @Override
    public void run() {
        /**循环条件是变量*/
        while (flag) {
            /**读取内容*/
            System.out.println(Reader());
        }

    }
}
