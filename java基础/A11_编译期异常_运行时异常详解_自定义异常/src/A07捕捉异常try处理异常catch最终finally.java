import java.io.IOException;
import java.net.ServerSocket;

public class A07捕捉异常try处理异常catch最终finally {
    public static void main(String[] args) {

        System.out.println(Finally());
    }



    public static int Finally() {
        int c = 0;
        try {
            c = c / 0;
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
            /**返回的是3*/
            return c = 3;

            /**finally是为一个一种方式能在return后面能执行的代码块*/
        } finally {
            /**在把c改是4*/
            c = 4;

            System.out.println(c);
        }

    }




    public static void ServerSocket() {
        ServerSocket serverSocket = null;
        try {
            ServerSocket ServerSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
