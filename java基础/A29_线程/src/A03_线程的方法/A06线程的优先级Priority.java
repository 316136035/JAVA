package A03_线程的方法;


/**优先级可以配1-10*/

public class A06线程的优先级Priority {
    public static void main(String[] args) {
        System.out.println("主线程的优先级："+Thread.currentThread().getPriority());

        Thread thread1 = new Thread(new PriorityText());
        /**线程可以具有的最小优先级。*/
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();

        Thread thread2 = new Thread(new PriorityText());
        /**分配给线程的默认优先级。*/
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread2.start();

        Thread thread3 = new Thread(new PriorityText());
        /**线程可以拥有的最大优先级。*/
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();

    }
}


class PriorityText  implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":   "+Thread.currentThread().getPriority());
    }
}