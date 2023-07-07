package A08_线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A01_线程池 {
    public static void main(String[] args) {

        /**创建线程池 :大小为10个线程*/
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /**执行线程*/
        executorService.execute(new ExecutorsText());
        executorService.execute(new ExecutorsText());
        executorService.execute(new ExecutorsText());
        executorService.execute(new ExecutorsText());
        /**关闭线程**/
        executorService.shutdown();



    }
}

class  ExecutorsText implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());


    }
}