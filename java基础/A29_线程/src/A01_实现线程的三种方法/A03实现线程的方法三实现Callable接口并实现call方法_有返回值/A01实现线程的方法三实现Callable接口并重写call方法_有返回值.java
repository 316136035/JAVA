package A01_实现线程的三种方法.A03实现线程的方法三实现Callable接口并实现call方法_有返回值;

import java.util.concurrent.*;

public class A01实现线程的方法三实现Callable接口并重写call方法_有返回值 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**创建 CallableText对象（实现 CallableText<T></>接口）*/
        CallableText callableText = new CallableText();
        /**创建规定的线程池*/
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /**线程池中的一个线程提交任务*/
        Future<String> submit = executorService.submit(callableText);
        try {
            /**获取线程任务的返回值*/
            String s = submit.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        /***未来的任务*/
        FutureTask<String> futureTask = new FutureTask(callableText);
        new  Thread(futureTask).start();
        System.out.println(" futureTask+"+futureTask.get());




        /**关闭线程*/
        executorService.shutdownNow();


    }
}
/**
 * 实现线程的方法三类要实现Callable<T>接口 实现 call()方法（有返回值）
 */
class CallableText implements Callable<String>{
    /**线程执行体 */
    @Override
    public String call() throws Exception {

        return " Callable";
    }
}