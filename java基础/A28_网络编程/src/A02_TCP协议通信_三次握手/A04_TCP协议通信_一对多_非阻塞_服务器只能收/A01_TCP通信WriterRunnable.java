package A02_TCP协议通信_三次握手.A04_TCP协议通信_一对多_非阻塞_服务器只能收;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class A01_TCP通信WriterRunnable implements  Runnable{
    private Socket socket;
    public A01_TCP通信WriterRunnable(Socket socket){
        this.socket=socket;



    }
    @Override
    public void run() {

        try (
             /**创建扫描仪*/
             Scanner scanner = new Scanner(System.in);
             /**获取outputStream输出流*/
             OutputStream outputStream = socket.getOutputStream();
             /**输出流转换*/
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
             ) {


            while (true){
                /**读取每一行*/
                String s = scanner.nextLine();
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                /**刷新*/
                bufferedWriter.flush();
                if (s.equals("esc")){
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
