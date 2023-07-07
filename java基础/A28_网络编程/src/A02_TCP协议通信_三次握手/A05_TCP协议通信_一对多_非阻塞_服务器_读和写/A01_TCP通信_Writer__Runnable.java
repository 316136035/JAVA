package A02_TCP协议通信_三次握手.A05_TCP协议通信_一对多_非阻塞_服务器_读和写;

import java.io.*;
import java.net.Socket;
/**
 * 客户端写入的线程
 **/
public class A01_TCP通信_Writer__Runnable implements  Runnable{
    /**Socket套接字*/
    private  Socket socket;
    /**控制器输入流*/
    private  BufferedReader   Scanner=null;
    /**输出流*/
    private  BufferedWriter  bufferedWriter=null;
    /**定义是否可以写入的变量*/
    private  boolean flag=true;

    public A01_TCP通信_Writer__Runnable(Socket socket){
        /**传入Socket套接字*/
        this.socket=socket;
        try {
            /**创建控制器输入流*/
            Scanner = new BufferedReader(new InputStreamReader(System.in));
            /**获取并构造器创建输出流**/
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            flag=false;
            CloseUtil.closeAll( bufferedWriter, Scanner);
        }

    }

    /**控制器输入流读取*/
    public String  Scanner() {
        String str="";
        try {
            str = Scanner.readLine();
        } catch (IOException e) {
            flag=false;
            CloseUtil.closeAll( bufferedWriter, Scanner);
        }
        return str;
    }


    /**输出流写出数据*/
    public   void Reader(String str){

        try {
            bufferedWriter.write(str);//写出
            bufferedWriter.newLine();//换行
            bufferedWriter.flush();//刷新
            System.out.println("客户端发送成功..:"+str);
        } catch (IOException e) {
            flag=false;
            CloseUtil.closeAll( bufferedWriter, Scanner);
        }


    }
    @Override
    public void run() {
        /**循环条件是变量*/
        while (flag){
            String scanner = Scanner();
            if ( scanner.equals("esc")){break;}
            /**写出数据 */
            this. Reader(scanner);

        }



    }
}
