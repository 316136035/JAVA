package A05_死锁开发不能出现;

import java.util.concurrent.TimeUnit;

/**
 * 死锁：多个线程互相抱着对方的需要的资源，然后形成的死锁
 */
public class A01死锁_开发不能出现 {
    public static void main(String[] args) {

        Makeup makeup1 = new Makeup(true, "周先生");
        Makeup makeup2 = new Makeup(false, "何东仪");

        makeup1.start();
        makeup2.start();

    }
}

/**
 * 口红的类
 */
class Lipstick {
}

/**
 * 镜子
 */
class Mirrir {
}

class Makeup extends Thread {
    /**
     * 需要的资源只有一份,用  static  来保证自有一份
     */
    static Lipstick lipstick = new Lipstick();
    static Mirrir mirrir = new Mirrir();

    Boolean choice;
    String name;

    public Makeup(Boolean choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        makeup();
       // makeup1();

    }

    /**
     * 死锁的化妆方法
     */
    private void makeup() {
        /**判断*/
        if (choice == true) {
            /**用户是ture 获取获取口红的锁*/
            synchronized (lipstick) {
                System.out.println(this.name + "获取口红的锁");
                try {
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**用户是ture 获取获取口红的锁再想获取镜子的锁*/
                synchronized (mirrir) {
                    System.out.println(this.name + "获取镜子的锁");

                }

            }

        } else {
            /**用户是false 获取获镜子的锁*/
            synchronized (mirrir) {
                System.out.println(this.name + "获取镜子的锁");
                try {
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /**用户是false 获取镜子的锁再想口红的锁"*/
                synchronized (lipstick) {
                    System.out.println(this.name + "获取口红的锁");

                }

            }


        }


    }

    /**
     * 解决死锁的化妆方法,不让他抱着对方的锁
     */
    private void makeup1() {
        /**用户是ture 获取获取口红的锁*/
        if (choice == true) {
            synchronized (lipstick) {
                System.out.println(this.name + "获取口红的锁");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**用户是ture 获取镜子的锁"*/
            synchronized (mirrir) {
                System.out.println(this.name + "获取镜子的锁");

            }

        } else {

            /**用户是ture 获取获取镜子的锁*/
            synchronized (mirrir) {
                System.out.println(this.name + "获取镜子的锁");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**用户是ture 获取获取口红的锁*/
            synchronized (lipstick) {
                System.out.println(this.name + "获取口红的锁");

            }


        }


    }
}
