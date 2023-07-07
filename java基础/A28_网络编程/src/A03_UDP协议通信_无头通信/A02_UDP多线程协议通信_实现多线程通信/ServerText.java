package A03_UDP协议通信_无头通信.A02_UDP多线程协议通信_实现多线程通信;

public class ServerText {
    public static void main(String[] args) {



      new Thread(new A02_UDP多线程协议通信Client(3333,"127.0.0.1",2222)).start();



        new Thread(new A01_UDP多线程协议通信Server(8888)).start();




    }
}
