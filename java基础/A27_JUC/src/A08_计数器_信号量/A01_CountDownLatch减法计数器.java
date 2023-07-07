package A08_计数器_信号量;

import java.util.concurrent.CountDownLatch;

public class A01_CountDownLatch减法计数器 {
    public static void main(String[] args) throws InterruptedException {
        /**减法计数器*/
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 8; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+":"+finalI);
                /**每使用完一条线程就减一*/
                countDownLatch.countDown();
            }).start();
           ;
        }
        /**等待上面线程执行完毕才执行下面的代码*/
        countDownLatch.await();


        System.out.println("关门");


    }
}
