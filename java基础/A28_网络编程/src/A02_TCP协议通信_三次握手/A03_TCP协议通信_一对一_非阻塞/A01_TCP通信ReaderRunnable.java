package A02_TCP协议通信_三次握手.A03_TCP协议通信_一对一_非阻塞;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class A01_TCP通信ReaderRunnable implements  Runnable {

    private Socket socket;
    /**构造参数  socket*/
    public A01_TCP通信ReaderRunnable(Socket socket){
        this.socket=socket;



    }
    @Override
    public void run() {
        /**获取输入流*/
        try (InputStream inputStream = socket.getInputStream();
             /**输入流转换*/
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
             ) {
            String str =null;
            /**判断*/
            while ((str=bufferedReader.readLine())!=null){
                if (str.equals("esc")){
                    System.out.println(socket.getRemoteSocketAddress()+ "已下线");
                    break;
                }else {
                    /**读取*/
                    System.out.println(socket.getRemoteSocketAddress()+str);

                }

            }

        }
        catch (SocketException e) {
            System.out.println(socket.getRemoteSocketAddress()+"我已经下线了");
        }catch (IOException e) {
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
