package A16_CompletableFuture异步回调;


import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class A02_CompletableFuture异步回调配置线程池 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutorText threadPoolExecutorText = new ThreadPoolExecutorText();


        /**---------------创建有返回值的异步回调方法-----------------*/
        CompletableFuture<String> StringCompletableFuture = CompletableFuture.supplyAsync(() -> {

            return "创建有返回值的异步回调方法";
            /**传入线程池*/
        }, threadPoolExecutorText.getThreadPoolExecutor());
        /**获取完成时的状态*/
        StringCompletableFuture.whenComplete(new BiConsumer<String, Throwable>() {
                    @Override
                    public void accept(String s, Throwable throwable) {
                        System.out.println(s+"成功的数据");     /**成功的数据*/
                        System.out.println(throwable.getMessage());    /**异常的信息*/}
                });

        CompletableFuture<String> exceptionally = StringCompletableFuture.exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable throwable) {
                return "错误";
            }
        });
        /**get抛异常（会阻塞）*/
        System.out.println(exceptionally.get());
        /**join不抛异常（会阻塞）*/
        System.out.println(exceptionally.join());


    }


}

class ThreadPoolExecutorText {
    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public ThreadPoolExecutorText() {
        /**创建自定义线程池*/
        threadPoolExecutor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),       /** 线程核心数量CPU密集型,cpu核数多小就设置多小 */
                Runtime.getRuntime().availableProcessors() * 2,      /** 线程核心数量CPU密集型*2,IO密集型 */
                1000,                   /***等待时间*/
                TimeUnit.SECONDS,          /**  时间单位*/
                new LinkedBlockingQueue<>(40),/**阻塞队列**/
                Executors.defaultThreadFactory(),/** 线程工厂(构造一个新的线程) 使用默认的*/
                new ThreadPoolExecutor.DiscardOldestPolicy());/** 4拒绝执行处理程序**/

    }


}