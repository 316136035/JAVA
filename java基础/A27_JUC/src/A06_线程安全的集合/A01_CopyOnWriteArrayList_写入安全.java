package A06_线程安全的集合;



import java.util.concurrent.CopyOnWriteArrayList;

public class A01_CopyOnWriteArrayList_写入安全 {
    public static void main(String[] args) {

        /**使用集合工具类把list编程线程安全**/
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        /**创建copyOnWriteArrayList_写入安全集合(优先使用)*/
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(()->{

                copyOnWriteArrayList.add(String.valueOf(finalI));

            }).start();
            System.out.println("==="+  copyOnWriteArrayList);

        }





    }
}
