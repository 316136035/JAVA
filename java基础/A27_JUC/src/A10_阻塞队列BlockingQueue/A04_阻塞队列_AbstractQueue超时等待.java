package A10_阻塞队列BlockingQueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class A04_阻塞队列_AbstractQueue超时等待 {
    public static void main(String[] args) {
        /**ArrayBlockingQueue 创建阻塞队列*/
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(3);


        try {
            arrayBlockingQueue.offer("A");
            arrayBlockingQueue.offer("B");
            arrayBlockingQueue.offer("C");
            /**阻塞队列只又3个索引,添加第4个会一直阻塞(设置超时时间)*/
            arrayBlockingQueue.offer("D", 1000, TimeUnit.MILLISECONDS);

            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll());

            /**获取第4个参数没有这个元素会一直阻塞*(设置超时时间)*/
           System.out.println(arrayBlockingQueue.poll(1000,TimeUnit.MILLISECONDS));


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
