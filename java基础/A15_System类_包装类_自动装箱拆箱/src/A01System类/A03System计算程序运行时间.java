package A01System类;

import java.util.concurrent.TimeUnit;

;

public class A03System计算程序运行时间  {
    public static void main(String[] args) {
        //获取价jre系统时间
        long start = System.currentTimeMillis();
        text();
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间:"+(end-start)+"毫秒");

    }

    public static void text() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(i);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

    }
}
