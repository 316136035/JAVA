package A08_计数器_信号量;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**并发限流*/
public class A03_Semaphore信号量 {
    public static void main(String[] args) {
        /**创建信号量(定车位为3个)*/
        Semaphore semaphore = new Semaphore(3);

        /**有100台车**/
        for (int i = 1; i <=100 ; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    /**得到车位(满了就等待)*/
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" 抢到车位  "+ finalI);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+" 离开车位  "+ finalI);
                    /**释放车位*/
                    semaphore.release();
                }
            } ).start(); ;
        }

    }
}
