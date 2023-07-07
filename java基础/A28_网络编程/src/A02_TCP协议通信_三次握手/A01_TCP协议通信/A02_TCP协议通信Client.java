package A02_TCP协议通信_三次握手.A01_TCP协议通信;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class A02_TCP协议通信Client {
    public static void main(String[] args) {


        try {
            /**创建一个客户端的套接字*/
            Socket socket = new Socket(InetAddress.getLocalHost(),8888);


            /**----------------发送数据------------------*/
            /**获取outputStream输出流*/
            OutputStream outputStream = socket.getOutputStream();
            /**outputStream---> OutputStreamWriter--->bufferedWriter*/
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            /**写入缓存*/
            bufferedWriter.write("我是中国人!!!!");
            bufferedWriter.newLine();
            /**刷新清空缓存区，把内容输出*/
            bufferedWriter.flush();


            /**----------------接受数据------------------*/
            /**获取 inputStream输入流*/
            InputStream inputStream = socket.getInputStream();
            /**inputStream--->InputStreamReader---> bufferedReader*/
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
