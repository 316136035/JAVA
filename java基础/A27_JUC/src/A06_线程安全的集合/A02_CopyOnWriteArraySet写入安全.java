package A06_线程安全的集合;



import java.util.concurrent.CopyOnWriteArraySet;

public class A02_CopyOnWriteArraySet写入安全 {
    public static void main(String[] args) {

        /**使用集合工具类把list编程线程安全**/
        //Set<Object> ArraySet = Collections.synchronizedSet(new CopyOnWriteArraySet<>());
        /**创建CopyOnWriteArraySet_写入安全集合(优先使用)*/
        CopyOnWriteArraySet<String> ArraySet = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(()->{
                ArraySet.add(String.valueOf(finalI));

            }).start();
            System.out.println("==="+  ArraySet);

        }





    }
}
