package A03_生产者和消费者的问题;

public class A01_synchronized生产者和消费者的问题使用while循环 {
    public static void main(String[] args) {

        Data Data = new Data();

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{


                try {
                    Data.increment();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"A").start();

        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {

                    Data.decrement();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"B").start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {

                    Data.decrement();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"C").start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {

                    Data.decrement();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"D").start();
        }


    }
}
//类中的两个方法synchronized锁 如果new一个对象 这个对象的两个方法锁是同一个锁！！！
//同一个对象中如increment方法this.notify();通知锁取消等待就是通知了decrement方法
class Data{
    private int number=0;
    //+1 必须有synchronized
    //等待必须用while 不用if 防止虚假唤醒
    //生产消费者业务代码流程其实就是1.等待2.通知
    public synchronized void increment() throws InterruptedException {
        while (number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其它线程我执行完了+1
        this.notifyAll();
    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其它线程我执行完了-1
        this.notifyAll();
    }

}