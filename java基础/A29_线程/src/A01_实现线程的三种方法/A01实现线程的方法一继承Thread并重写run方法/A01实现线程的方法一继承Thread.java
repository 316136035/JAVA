package A01_实现线程的三种方法.A01实现线程的方法一继承Thread并重写run方法;


/**
 * 实现线程的方法一类要继承Thread并重写run()方法
 */
public class A01实现线程的方法一继承Thread {
    public static void main(String[] args) {
        /**创建线程类*/
        ThreadText threadText = new ThreadText();
        /**调用线下*/
        threadText.start();
        System.out.println("我是主线程..");
    }
}

class ThreadText extends Thread {
    @Override
    public void run() {
        /**线程执行体*/
        for (int i = 1; i <= 1000; i++) {
            System.out.println("我是继承Thread的线程" + this.getName() + "     " + i);
        }

    }
}