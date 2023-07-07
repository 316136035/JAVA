package A04_并发_多个线程使用同一个资源不安全;import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;


public class A03线程不安全的集合 {
    public static void main(String[] args) throws InterruptedException {
      /**不是线程安全的LIst*/
    List<String> list = new ArrayList<>();

    /**是线程安全的list*/
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 1000; i++) {

            int finalI = i;
            /**创建线程 使用lamde表达式*/
            new Thread(() -> {

                synchronized (list){
                    list.add(Thread.currentThread().getName());}
            }

            ).start();

        }

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(list.size());



    }
}
