package A16_CompletableFuture异步回调;


import java.util.concurrent.*;
import java.util.function.BiConsumer;

public class A03_测试CompletableFuture异步回调配置线程池 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFutur1 completableFutur1 = new CompletableFutur1();
        for (int i = 0; i <100 ; i++) {
            completableFutur1.interface1( i);
            TimeUnit.MILLISECONDS.sleep(500);

        }



    }



}


class   CompletableFutur1{
    ThreadPoolExecutorText1 threadPoolExecutorText1 = new ThreadPoolExecutorText1();
    interfaceText interfaceText = new interfaceText();
    public  void interface1(int i) throws InterruptedException {

        /**---------------创建有返回值的异步回调方法-----------------*/
        CompletableFuture<String> StringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {

            String s = interfaceText.interface1();
            System.out.println(Thread.currentThread().getName()+"   "+i+"interface1()发送请求中");
            return Thread.currentThread().getName()+"   "+s+"  获取结果成功";
            /**传入线程池*/
        }, threadPoolExecutorText1.getThreadPoolExecutor());
        StringCompletableFuture1.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                if (s!=null){
                    System.out.println(s +"     "+Thread.currentThread().getName());
                }
            }
        });

        /**---------------创建有返回值的异步回调方法-----------------*/
        CompletableFuture<String> StringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            String s = interfaceText.interface2();
            System.out.println(Thread.currentThread().getName()+"   "+i+"interface2() 发送请求中");

            return Thread.currentThread().getName()+"   "+s+"  获取结果成功";
            /**传入线程池*/
        }, threadPoolExecutorText1.getThreadPoolExecutor());
        StringCompletableFuture2.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                if (s!=null){
                    System.out.println(s +"     "+Thread.currentThread().getName());
                }
            }
        });

        /**---------------创建有返回值的异步回调方法-----------------*/
        CompletableFuture<String> StringCompletableFuture3 = CompletableFuture.supplyAsync(() -> {
            String s = interfaceText.interface3();
            System.out.println(Thread.currentThread().getName()+"   "+i+"interface3()发送请求中");

            return Thread.currentThread().getName()+"   "+s +"  获取结果成功";
            /**传入线程池*/
        }, threadPoolExecutorText1.getThreadPoolExecutor());
        StringCompletableFuture3.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                if (s!=null){
                    System.out.println(s +"     "+Thread.currentThread().getName());
                }
            }
        });




    }

}


class interfaceText{
    public  String interface1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "interface1()";
    }
    public   String  interface2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "interface2()";
    }
    public   String  interface3() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "interface3()";
    }


}

class ThreadPoolExecutorText1 {
    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public ThreadPoolExecutorText1() {
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