package A01_实现线程的三种方法.A02实现线程的方法二实现Runnable接口并实现run方法;

public class A01实现线程的方法二实现Runnable接口并实现run方法 {
    public static void main(String[] args) {

        /**创建Runnable对象（实现Runnable接口）*/
        RunnableText runnableText = new RunnableText();
        /**创建线程（传入Runnable对象）*/
        Thread thread = new Thread(runnableText,"线程名字：1");
        /**执行线程*/
        thread.start();

    }
}


/**定义类（实现Runnable接口）*/
class RunnableText implements  Runnable{
    /**线程执行体*/
    @Override
    public void run() {
        for (int i = 0; i <=1000 ; i++) {

            System.out.println(Thread.currentThread().getName()+"   "+i
            );
        }

    }
}