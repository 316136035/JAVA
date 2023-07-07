package A02_TCP协议通信_三次握手.A02_TCP协议通信_一对一_阻塞的现象;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class A01_TCP协议通信Server_ {
    public static void main(String[] args) {

        try (/**创建一个服务端的套接字*/
             ServerSocket serverSocket = new ServerSocket(8888);
             /**阻塞监听链接*/
             Socket accept = serverSocket.accept();
             /**获取输入流*/
             InputStream inputStream = accept.getInputStream();
             /**输入流转换**/
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

             /**获取输出流*/
             OutputStream outputStream = accept.getOutputStream();
             /**输出流流转换**/
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

             /**创建扫描仪*/
             Scanner scanner = new Scanner(System.in)

        ) {
            System.out.println("客户端已成功接入..");
            /**先读*/
            while (true) {
                String s1 = bufferedReader.readLine();

                if (s1.equals(886)) {
                    System.out.println(accept.getLocalSocketAddress() + "已经下线.");
                    break;
                } else {
                    System.out.println(accept.getLocalSocketAddress() + "发送：" + s1);
                }

                System.out.println("...............");
                /**后写*/
                String s = scanner.nextLine();


                bufferedWriter.write(s);

                bufferedWriter.newLine();

                bufferedWriter.flush();
                System.out.println("服务器发送了" + s);


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}