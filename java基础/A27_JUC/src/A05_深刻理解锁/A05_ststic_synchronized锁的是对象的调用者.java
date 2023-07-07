package A05_深刻理解锁;


import java.util.concurrent.TimeUnit;

public class A05_ststic_synchronized锁的是对象的调用者 {
    public static void main(String[] args) {

        Phone5 phone5 = new Phone5();
        Phone5 phone6 = new Phone5();


        new Thread(()->{
            try {
                phone5.sendSms();
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
                phone6.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程B").start();

        new Thread(()->{
            phone5.sleep();
        },"线程C").start();



    }
}
class Phone5{

    /**static synchronized锁的是class
     *两个方法用的是统一把锁,谁先拿到谁先执行
     * */
    public static synchronized void sendSms() throws InterruptedException {

        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+"="+"发短信");

    }

    public static synchronized void call() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"="+"打电话");
    }

    /**静态方法,没有锁*/
    public static void sleep() {
        System.out.println(Thread.currentThread().getName()+"="+"sleep() ");
    }


}