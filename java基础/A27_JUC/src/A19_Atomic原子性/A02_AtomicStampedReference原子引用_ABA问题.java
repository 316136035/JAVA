package A19_Atomic原子性;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class A02_AtomicStampedReference原子引用_ABA问题 {
    public static void main(String[] args) {

        /**AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题
         * 正常在业务旗作，这里面比较的都是一个个对象**/
        AtomicStampedReference<Integer> AtomicStampedReference = new AtomicStampedReference<>(1,1);


        new  Thread(()->{
            System.out.println("线程A版本号1："+AtomicStampedReference.getStamp());

            boolean b = AtomicStampedReference.compareAndSet(1, 2, AtomicStampedReference.getStamp(), AtomicStampedReference.getStamp() + 1);
            System.out.println(b);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b1 = AtomicStampedReference.compareAndSet(2, 1, AtomicStampedReference.getStamp(), AtomicStampedReference.getStamp() + 1);
            System.out.println(b1);

            System.out.println("线程A版本号2："+AtomicStampedReference.getStamp());

        },"线程A").start();





        new  Thread(()->{
            System.out.println("线程B版本号："+AtomicStampedReference.getStamp());


            boolean b = AtomicStampedReference.compareAndSet(1, 111, AtomicStampedReference.getStamp(), AtomicStampedReference.getStamp() + 1);
            System.out.println(b);


            System.out.println("线程B版本号3："+AtomicStampedReference.getStamp());
        },"线程B").start();

    }
}
