package A19_Atomic原子性;


import java.util.concurrent.atomic.AtomicInteger;

public class A01_compareAndSet期望值 {
    public static void main(String[] args) {


            /**创建有原子性的整数*/
        AtomicInteger atomicInteger = new AtomicInteger(1991);

        /**期望值,1991,更新成2020,返回布尔类型   compareAndSet 是CPU的并发源于*/
        System.out.println(atomicInteger.compareAndSet(1991, 2020));
        System.out.println(atomicInteger.get());


        /**递增*/
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
        /**递减*/
        atomicInteger.getAndDecrement();
        System.out.println(atomicInteger.get());


    }
}
