package A02_TCP协议通信_三次握手.A02_TCP协议通信_一对一_阻塞的现象;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class A02_TCP协议通信Client_ {
    public static void main(String[] args) {


        /**创建一个客户端的套接字*/
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

             /**获取outputStream输出流*/
             OutputStream outputStream = socket.getOutputStream();
             /**输出流转换*/
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
             /**创建扫描仪*/
             Scanner scanner = new Scanner(System.in);
             /**获取inputStream输入流*/
             InputStream inputStream = socket.getInputStream();
             /**输入流流转换*/
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream ))


        )
        {
            System.out.println("客户端接入成功..");
            while (true){

                /**----------------发送数据------------------*/

            /**先写*/
            String str = scanner.nextLine();
                bufferedWriter.write( str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                System.out.println("客户端发送成功...:"+str);

                if (str.equals(886)){
                    System.out.println("客户端已关闭");
                }

                /**后读*/
                System.out.println("服务器回话："+bufferedReader.readLine());


            }











        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}