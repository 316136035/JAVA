package A05_深刻理解锁;


import java.util.concurrent.TimeUnit;

public class A02_synchronized锁的是对象的调用者 {
    public static void main(String[] args) {

        Phone1 phone1 = new Phone1();

        new Thread(()->{
            try {
                phone1.sendSms();
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
                phone1.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程B").start();


        new Thread(()->{

                phone1.hello();

        },"线程C").start();


    }
}
class Phone1{

    /**synchronized锁的是对象的调用者
     *两个方法用的是统一把锁,谁先拿到谁先执行
     * */
    public synchronized void sendSms() throws InterruptedException {

        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+"="+"发短信");

    }

    public synchronized void call() throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"="+"打电话");
    }

    /**这里没有锁,可以直接运行,不受锁的印象*/
    public void hello() {

        System.out.println(Thread.currentThread().getName()+"="+" hello()");
    }





}