package A07_Callable_有返回值的线程;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class A01_Callable_有返回值的线程 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableText callableText = new CallableText(10, 9);
        /**FutureTask(参数是Callable)*/
        FutureTask  futureTask=new FutureTask<String>(callableText);
        /**FutureTask实现的Runnable接口,执行线程*/
        new Thread( futureTask,"A线程").start();
        new Thread( futureTask,"A线程").start();/**结果会会被缓存,效率高(只有一个返回值)*/
        /**返回值,可能产生阻塞,或者使用异步通宵*/
        System.out.println(futureTask.get());
    }
}
/**使用lanbda不用实现接口<泛型是返回值>*/
class CallableText  implements Callable<String> {
    int A;
    int B;


    public CallableText(int A, int B) {
        this.A=A;
        this.B=B;

    }

/**实现call()方法*/
    public String call() throws Exception {

        int i = A - B;

        return "结果:"+Thread.currentThread().getName()+" "+String.valueOf(i);
    }
}