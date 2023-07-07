package A02_TCP协议通信_三次握手.A05_TCP协议通信_一对多_非阻塞_服务器_读和写;


import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;

public class A01_TCP通信_Reader_Writer_Runnable implements Runnable {

    /**Socket套接字*/
    private Socket socket;
    /**输入流*/
    private BufferedReader bufferedReader = null;
    /**输出流*/
    private BufferedWriter bufferedWriter = null;
    /**定义是否可以读和发的变量*/
    private boolean flag = true;

    public A01_TCP通信_Reader_Writer_Runnable(Socket socket) {
        try {
            /**获取并构造器创建输入流**/
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /**获取并构造器创建输出流**/
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            /**出现异常变量付false*/
            flag = false;
            /**关闭流*/
            CloseUtil.closeAll(bufferedWriter, bufferedReader);
        }


    }
    /**输入流读取数据*/
    public String Reader() {
        String str = "";
        try {
            /**输入流读取*/
            str = bufferedReader.readLine();

        } catch (SocketException e){
            /**出现异常删除这个对象*/
            A02_TCP_Server服务端.hashSet.remove(this);
            /**出现异常变量付false*/
            flag = false;
            /**关闭流*/
            CloseUtil.closeAll(bufferedReader);
        }

        catch (IOException e) {

            /**出现异常删除这个对象*/
            A02_TCP_Server服务端.hashSet.remove(this);
            /**出现异常变量付false*/
            flag = false;
            /**关闭流*/
            CloseUtil.closeAll(bufferedReader);

        }
        return str;
    }

    /**输出流写出数据*/
    public void Writer(String str) {
        if (str != null && str.length() != 0) {
            try {
                bufferedWriter.write(str);//写出
                bufferedWriter.newLine();//换行
                bufferedWriter.flush();//刷新
            } catch (IOException e) {
                /**出现异常删除这个对象*/
                A02_TCP_Server服务端.hashSet.remove(this);
                /**出现异常变量付false*/
                flag = false;
                /**关闭流*/
                CloseUtil.closeAll(bufferedWriter);

            }
        }

    }

    /**客户端发送数据(服务器转发到全部客户端,不包含自己)*/
    public void   WriterAll() {
        /**获取服务端的集合*/
      HashSet<A01_TCP通信_Reader_Writer_Runnable> hashSet = A02_TCP_Server服务端.hashSet;
      /**输入流读取数据*/
        String reader = this.Reader();
        /**遍历服务端的集合*/
        for (A01_TCP通信_Reader_Writer_Runnable writer_runnable : hashSet) {
            if (writer_runnable==this){continue;}
            /**向每一个在线的客户端发送数据*/
            writer_runnable.Writer("服务器转发数据："+reader);
        }



    }

    @Override
    public void run() {
        while (flag) {
          //  this.Writer("服务器转发数据：" + this.Reader());
            /**客户端发送数据(服务器转发到全部客户端,不包含自己)*/
            WriterAll();



        }

    }
}
