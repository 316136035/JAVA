package A20_可重入锁;

public class A01_synchronized可重入锁 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{ phone.sms();},"线程1").start();
        new Thread(()->{ phone.sms();},"线程2").start();



    }
}
class Phone{
    public  synchronized  void sms(){
        System.out.println("发短信");
        call();
    }

    public  synchronized  void call(){
        System.out.println("打电话");
    }



}