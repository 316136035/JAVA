package A03_UDP协议通信_无头通信.A02_UDP多线程协议通信_实现多线程通信;

public class Client1Txet {
    public static void main(String[] args) {

        /**发送端 本地端口7777, 本机IP, 远程端口*/
        new Thread(new A02_UDP多线程协议通信Client(1111,"127.0.0.1",8888)).start();
        /**接受端  本地端口2222    */
       new Thread(new A01_UDP多线程协议通信Server(2222)).start();



    }
}
