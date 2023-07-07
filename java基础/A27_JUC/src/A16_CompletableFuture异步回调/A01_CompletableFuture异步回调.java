package A16_CompletableFuture异步回调;


import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class A01_CompletableFuture异步回调 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /**----------------创建没返回值的异步回调方法--------------*/
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {


            System.out.println(Thread.currentThread().getName() + "创建没有参数的异步回调方法");
        });
        /**执行线程*/
        voidCompletableFuture.get(100, TimeUnit.MILLISECONDS);


        /**---------------创建有返回值的异步回调方法-----------------*/
        CompletableFuture<String> StringCompletableFuture = CompletableFuture.supplyAsync(() -> {

            int i = 10 / 0;
            return "创建有返回值的异步回调方法";
        });
        StringCompletableFuture.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {

                System.out.println(s);     /**成功的数据*/
                System.out.println(throwable);    /**异常的信息*/
            }
        }).exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable throwable) {
                return "错误";
            }
        }).get();

    }


}
