package A12_线程池_CPU密集型和IO密集型;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A02_Executors创建线程的工具类_不建议使用 {
    public static void main(String[] args) {
        /**不建议使用,请用ThreadPoolExecutor来创建*/
        ExecutorService SingleThread = Executors.newSingleThreadExecutor();
        ExecutorService newFixedThread = Executors.newFixedThreadPool(10);
        ExecutorService CachedThread = Executors.newCachedThreadPool();
    }
}
