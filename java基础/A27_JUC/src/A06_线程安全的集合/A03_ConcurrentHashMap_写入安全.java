package A06_线程安全的集合;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class A03_ConcurrentHashMap_写入安全 {
    public static void main(String[] args) throws InterruptedException {

        /**把HashMap转成线程安全*/
        Map<String, String> Map = Collections.synchronizedMap(new HashMap<>());
        /**线程ConcurrentHashMap(写入安全,优先使用)*/
        ConcurrentHashMap<String, String> HashMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {

            int finalI = i;
            new Thread(() -> {
                System.out.println(String.valueOf(finalI));
                HashMap.put(String.valueOf(finalI), "写入安全");
            }).start();

           System.out.println(HashMap);

        }







    }
}
