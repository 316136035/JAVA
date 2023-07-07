package A11_SynchronousQueue同步队列;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;


/**同步队列
 和其他的BlockingQueue 不一样，
 SynchronousQueue
 不存储元素put了一个元素，
 必须从里面先take取出来，
 否则不能在put进去值!*/
public class A01_SynchronousQueue同步队列 {
    public static void main(String[] args) throws InterruptedException {
        /**创建同步队列*/
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "-->A");
                synchronousQueue.put("A");

                System.out.println(Thread.currentThread().getName() + "-->B");
                synchronousQueue.put("B");

                System.out.println(Thread.currentThread().getName() + "-->C");
                synchronousQueue.put("C");



            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "线程1").start();


        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "消费:" +synchronousQueue.take());

                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "消费:" + synchronousQueue.take());

                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "消费:" + synchronousQueue.take());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "线程2").start();

        while (true){
            TimeUnit.MILLISECONDS.sleep(100);
        new Thread(()->{

            System.out.print( synchronousQueue .size()+"    ");

        }).start();}


    }
}
