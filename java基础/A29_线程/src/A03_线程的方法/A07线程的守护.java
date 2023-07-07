package A03_线程的方法;

/**
 * 线程分为用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 * 如,后台记录操作日志,监控内存,垃圾回收等待..*/
public class A07线程的守护 {
    public static void main(String[] args) {

        Thread thread = new Thread(new 守护线程());
        thread.setDaemon(true);/**设置为守护线程, 程序是 while (true)但是设置为守护线程就会停止*/
        thread.start();/**启动线程*/

        new Thread(new 默认线程()).start();

    }
}


class 守护线程 implements  Runnable{
    @Override
    public void run() {
        while (true){

            System.out.println("守护线程");
        }
    }
}
class 默认线程  implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i <1000000 ; i++) {
            System.out.println("默认线程" );

        }

    }
}