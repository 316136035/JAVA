package A03_线程的方法;

public class A05线程的状态State {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);

                }
                System.out.println(".....................");

            }
        });

        /**观察启动前的状态*/
        Thread.State state = thread.getState();
        System.out.println("启动前的状态:" + state);

        /**观察启动后的状态*/
        thread.start();
        System.out.println("观察启动后的状态:" + thread.getState());


        /**只要线程不终止就一直运行*/
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**更新线程状态*/
            System.out.println(Thread.currentThread().getName() + "线程状态:" + thread.getState());
            System.out.println(state);

        }



    }


}
