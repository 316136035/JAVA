package A10_阻塞队列BlockingQueue;



import java.util.concurrent.ArrayBlockingQueue;

public class A02_阻塞队列_AbstractQueue不报异常返回ture_false {
    public static void main(String[] args) {
        /**ArrayBlockingQueue 创建阻塞队列*/
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

        for (int i = 0; i < arrayBlockingQueue.size()+1; i++) {
            /**超过阻塞队列索引会报false*/
            System.out.println(arrayBlockingQueue.offer(String.valueOf(i)));

        }

        System.out.println(arrayBlockingQueue.size());

        for (int i = 0; i < arrayBlockingQueue.size()+4; i++) {
            /**没有元素返回null*/
            System.out.println(arrayBlockingQueue.poll());
        }

        /**查看是否有首就元素（没有就元返回null）*/
        System.out.println(arrayBlockingQueue.peek()+"peek");


    }
}
