package A10_阻塞队列BlockingQueue;



import java.util.concurrent.ArrayBlockingQueue;

public class A01_阻塞队列_AbstractQueue报异常的的写法 {
    public static void main(String[] args) {

        /**ArrayBlockingQueue 创建阻塞队列*/
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

        for (int i = 0; i < arrayBlockingQueue.size()+1; i++) {

            /**报异常*/
            boolean add = arrayBlockingQueue.add(String.valueOf(i));

        }


        for (int i = 0; i < arrayBlockingQueue.size()+5; i++) {
            /**报异常*/
            System.out.println(arrayBlockingQueue.remove());
        }

        /**查看是否有首就元素（报异常）*/
        System.out.println(arrayBlockingQueue.element());


    }
}
