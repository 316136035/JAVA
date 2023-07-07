package A01_实现线程的三种方法.A02实现线程的方法二实现Runnable接口并实现run方法;

import java.util.concurrent.TimeUnit;


public class A03龟兔赛跑 {
    public static void main(String[] args) {
        /**两条线程共享一个对象(跑道)**/
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "小龟").start();

    }
}

/**
 * 定义类（实现Runnable接口）
 */
class Race implements Runnable {
    /**
     * 线程执行体
     */
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            /**调用判断是否完成比赛的方法*/
            boolean b = gameOver(i);
            /**判断返回参数 ture就停止当前线程*/
            if (b) {
                /**停止当前线程*/
                break;
            }
            /** 线程执行体*/
            System.out.println(Thread.currentThread().getName() + "正在跑第" + i + "圈");
            /**模拟兔子睡觉*/
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ".....................正在在睡觉");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }

    /**
     * 判断是否完成比赛
     */
    private boolean gameOver(int steps) {
        /**静态变量开始的时候是null*/
        if (winner != null) {
            return false;
        }
        /**判断谁先跑到第100圈*/
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("第一名:" + winner);
            return true;
        }

        return false;
    }
}