package A05_深刻理解锁;


import java.util.concurrent.TimeUnit;

public class A01_synchronized锁的是对象的调用者 {
    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"线程A").start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(()->{
            try {
                phone.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程B").start();


    }
}
class Phone{

    /**synchronized锁的是对象的调用者
     *两个方法用的是统一把锁,谁先拿到谁先执行
     * */
    public synchronized void sendSms() throws InterruptedException {

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+"="+"发短信");

    }

    public synchronized void call() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"="+"打电话");
    }



}