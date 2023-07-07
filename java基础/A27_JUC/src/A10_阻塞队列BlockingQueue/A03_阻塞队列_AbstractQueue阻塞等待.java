package A10_阻塞队列BlockingQueue;



import java.util.concurrent.ArrayBlockingQueue;

public class A03_阻塞队列_AbstractQueue阻塞等待 {
    public static void main(String[] args) {
        /**ArrayBlockingQueue 创建阻塞队列*/
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(3);


        try {
            arrayBlockingQueue.put("A");
            arrayBlockingQueue.put("B");
            arrayBlockingQueue.put("C");
            /**阻塞队列只又3个索引,添加第4个会一直阻塞*/
           /// arrayBlockingQueue.put("D");

            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            /**获取第4个参数没有这个元素会一直阻塞*/
            System.out.println(arrayBlockingQueue.take());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
