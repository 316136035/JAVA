package A01_并发_并行;

public class A01并发和并行理解 {

    public static void main(String[] args) {

        /**
         *并发、并行
         * 并发( 多线程操作同一个资源）
         * CPU 一核，模拟出来多条线程，天下武功，唯快不破，快速交替
         * 并行(多个人一起行走 )
         * CPU 多核，多个线程可以同时执行,*/

        /**获取cpu核数*/
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);





    }

}
