package A03_线程的方法;


import java.util.concurrent.TimeUnit;

/**
 * 建议线程正常停止
 * 建议使用标志位ture--=false来停止
 */
public class A01停止线程 {
    public static void main(String[] args) throws InterruptedException {
        /**创建实现Runnable的类*/
        TestStop testStop = new  TestStop();
        /**创建线程*/
        Thread thread = new Thread(testStop);
        /**调用线程*/
        thread.start();
        /**模拟线程停止*/
        for (int i = 0; i < 1000; i++) {
            TimeUnit.MILLISECONDS.sleep(1);
            if (i>=500){testStop.stop();}
        }

    }
}
/**实现Runnable的方法创建线程*/
class TestStop implements Runnable {
    /**标志位ture*/
    private Boolean flag = true;
    /**线程执行体*/
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+":"+i++);
        }

    }

    /**线程停止的方法*/
    public void stop() {

        flag =false;
    }
}