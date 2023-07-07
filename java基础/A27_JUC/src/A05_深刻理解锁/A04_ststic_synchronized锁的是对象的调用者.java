package A05_深刻理解锁;


import java.util.concurrent.TimeUnit;

public class A04_ststic_synchronized锁的是对象的调用者 {
    public static void main(String[] args) {

        Phone4 phone4 = new Phone4();

        new Thread(()->{
            try {
                phone4.sendSms();
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
                phone4.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程B").start();


    }
}
class Phone4{

    /** static synchronized锁的是class
     *两个方法用的是统一把锁,谁先拿到谁先执行
     * */
    public static synchronized void sendSms() throws InterruptedException {

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+"="+"发短信");

    }

    public static synchronized void call() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"="+"打电话");
    }



}