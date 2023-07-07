package A12_线程池_CPU密集型和IO密集型;


import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class A01_ThreadPoolExecutor创建线程池_优先使用 {
    public static void main(String[] args) {
        /**
         * int corePoolSize,                     线程核心数量
         * int maximumPoolSize,                  线程最大数量
         * long keepAliveTime,                   等待时间
         * imeUnit unit,                         时间单位
         * BlockingQueue<Runnable> workQueue,    阻塞队列
         * ThreadFactory threadFactory,          线程工厂(构造一个新的线程)
         * RejectedExecutionHandler handler)     4拒绝执行处理程序
         *
         *
         *
         * 4拒绝执行处理程序
         *   new ThreadPoolExecutor.AbortPolicy()           当线程最大数量+阻塞队列数量-->就会抛出异常
         *   new ThreadPoolExecutor.CallerRunsPolicy()      哪来就回去哪来
         *   new ThreadPoolExecutor.DiscardPolicy()         当线程最大数量+阻塞队列数量-->丢弃政策--不抛出异常
         *   new ThreadPoolExecutor.DiscardOldestPolicy()    当线程最大数量+阻塞队列数量满了 尝试使用最早的线程---不抛出异常
         * **/

        /**获取CPO核数*/
        int corePoolSize = Runtime.getRuntime().availableProcessors();

        /**创建自定义线程池*/
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,       /** 线程核心数量CPU密集型,cpu核数多小就设置多小 */
                corePoolSize*2,      /** 线程核心数量CPU密集型*2,IO密集型 */
                1000,                   /***等待时间*/
                TimeUnit.SECONDS,          /**  时间单位*/
                new LinkedBlockingQueue<>(40),/**阻塞队列**/
                Executors.defaultThreadFactory(),/** 线程工厂(构造一个新的线程) 使用默认的*/
                new ThreadPoolExecutor.DiscardOldestPolicy());/** 4拒绝执行处理程序**/


        try {
            for (int i = 1; i <= 10000; i++) {
                threadPoolExecutor.submit(()->{
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**关闭线程池*/
            threadPoolExecutor.shutdown();
        }
    }
}
