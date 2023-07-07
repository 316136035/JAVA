package A03_线程的方法;

/**礼让线程，让当前正在执行的线程暂停，
 * 但不阻塞将线程从运行状态转为就绪状态
 * 让cpu重新调度，礼让不一定成功!看CPU心情*/
public class A03线程的礼让yield {
    public static void main(String[] args) {
        new Thread(new YieldText(),"线程一").start();
        new Thread(new YieldText(),"线程二").start();

    }
}
class YieldText implements  Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"线程开始执行");

        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");




    }
}