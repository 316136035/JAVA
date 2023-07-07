package A02_TCP协议通信_三次握手.A04_TCP协议通信_一对多_非阻塞_服务器只能收;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 自定义线程池 {

    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    private int corePoolSize;//默认线程数
    private int maximumPoolSize;//最大线程数
    private int keepAlivelime;//超时时间
    private int LinkedBlockingQueue;//阻塞队列

        /**构造器创建线程池*/
    public 自定义线程池(int corePoolSize, int maximumPoolSize, int keepAlivelime, int linkedBlockingQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAlivelime = keepAlivelime;
        this.LinkedBlockingQueue = linkedBlockingQueue;
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAlivelime, TimeUnit.SECONDS, new LinkedBlockingQueue<>(LinkedBlockingQueue));
    }


    /**
     * 线程池执行方法
     */
    public void execute(Runnable runnable) {
        threadPoolExecutor.submit(runnable);

    }


}
