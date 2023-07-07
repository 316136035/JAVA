import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;

public class A06编译时的异常 {
    public static void main(String[] args) {


        /**   FileWriter fileWriter = new FileWriter("A03运行时异常Exception.java");
         * 编译时的异常 我们程序可以遇见性的
         * */
        //            ServerSocket    serverSocket = new ServerSocket(8888);
//            FileWriter   fileWriter = new FileWriter("A03运行时异常Exception.java");
        ServerSocket serverSocket = null;
        FileWriter fileWriter = null;

        try {
            serverSocket = new ServerSocket(8888);
            fileWriter = new FileWriter("A03运行时异常Exception.java");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

