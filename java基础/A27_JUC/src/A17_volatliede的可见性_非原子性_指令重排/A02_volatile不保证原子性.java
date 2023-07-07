package A17_volatliede的可见性_非原子性_指令重排;

import java.util.concurrent.atomic.AtomicInteger;
/**原子性: 不可分割
 线程A在执行任务的时候，
 不能被打扰的，也不能被分割。
 但是volatile不保证原子性
 * */
public class A02_volatile不保证原子性 {

    /**如果不加 lock 和 synchronized ，怎么样保证原子性
     *  使用原子性类
     * 这些类的底层都直接和操作系统挂钩!在内存中修改值!Unsafe类是一个很特殊的存在 !*/
    private volatile  static    AtomicInteger num=new AtomicInteger();

    public  static void  add(){
        /**AtomicInteger加1的方法*/
        num.getAndIncrement();
    }
    public static void main(String[] args) {


        /**结果应该是20000*/
        for (int j = 0; j < 20; j++) {
            new Thread(()->{
                for (int i = 0; i < 1000; i++) {
                    add();
                }
            }).start();
        }

        /**判断线程数量*/
        while (Thread.activeCount()>2){
            /**线程礼让*/
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"   "+num);

    }


}
