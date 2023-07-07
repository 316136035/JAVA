package A21_自旋锁_死锁.A02_死锁;



/**idea  可以进终端
 * 1.使用命令 jps -l 查看进程号
 * 2.使用命令 jstack   进程号
 *
 *
 */
public class A01_死锁 {
    public static void main(String[] args) {
        String  lock1=" lock1";
        String  lock2=" lock2";

        new Thread(  new MyThread(lock1, lock2) ).start();
        new Thread(  new MyThread(lock2, lock1) ).start();

    }
}
class MyThread implements Runnable{

    private String lock1;
    private String lock2;

    public MyThread(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }


    @Override
    public void run() {

        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "lock1" + "获取-->" + lock2);
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "lock1" + "获取-->" + lock1);
            }
        }
    }
}