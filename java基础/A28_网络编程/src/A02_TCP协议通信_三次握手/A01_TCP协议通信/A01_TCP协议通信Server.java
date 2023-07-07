package A02_TCP协议通信_三次握手.A01_TCP协议通信;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class A01_TCP协议通信Server {
    public static void main(String[] args) {
        ServerSocket serverSocket= null;
        InputStream inputStream= null;
        BufferedReader bufferedReader = null;
        try {
            /**创建一个服务端的套接字*/
            serverSocket = new ServerSocket(8888);

            System.out.println("服务器已启动");

            /**监听链接*/
            Socket socket = serverSocket.accept();

            while (true) {
                /**----------------接受------------------*/
                /**获取 inputStream输入流*/
                inputStream = socket.getInputStream();
                /**inputStream--->InputStreamReader---> bufferedReader*/
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                System.out.println(bufferedReader.readLine());

                /**----------------发送数据------------------*/
                /**获取OutputStream输出流*/
                OutputStream outputStream = socket.getOutputStream();
                /**outputStream--->OutputStreamWriter>BufferedWriter*/
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write(socket.getInetAddress() + "接受完毕..");
                bufferedWriter.flush();
                /**关闭输出流**/
                socket.shutdownOutput();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            try {
                if (bufferedReader!=null){bufferedReader.close();}
                if (inputStream!=null){inputStream.close();}
                if (serverSocket!=null){serverSocket.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
