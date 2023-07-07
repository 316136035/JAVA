package A02_TCP协议通信_三次握手.A05_TCP协议通信_一对多_非阻塞_服务器_读和写;


import java.io.Closeable;

public class CloseUtil {
    public static void closeAll (Closeable...Closeables) {
        for (Closeable closeable : Closeables) {
            if (closeable!=null){
                try {
                    Closeables.clone();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }





    }


}
