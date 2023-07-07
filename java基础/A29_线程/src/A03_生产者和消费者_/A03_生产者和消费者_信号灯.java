package A03_生产者和消费者_;

public class A03_生产者和消费者_信号灯 {
    public static void main(String[] args) {
        TV tv = new TV();

        new Player生产者(tv).start();
        new Watcher消费者(tv).start();


    }
}

/***生产者**/
class Player生产者 extends Thread {
    TV tv;
    public  Player生产者(  TV tv){this.tv=tv;}

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("快乐大本营");
            }else {
                this.tv.play("抖音:记录美好生活");
            }
        }
    }
}

/**
 * 消费者
 */
class Watcher消费者 extends Thread {
    TV tv;
    public Watcher消费者(  TV tv){this.tv=tv;}

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watvh();
        }

    }
}


/**电视*/
class TV {
    /**表演的节目*/
    String voice;
    /**标志位*/
    boolean flag = true;

    /**表演*/
    public synchronized void play(String voice) {
        /**不等于真就等待*/
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**等于真就表演*/
        if (flag){
            /***等于真的唤醒 观看者*/
            this.notifyAll();
            this.voice = voice;
            /***/
            this.flag=!this.flag;
        }




    }
    /**观看*/
    public synchronized void watvh() {
        /**等于真就等待*/
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**不等于真就观看*/
        if (!flag){
            System.out.println("观看!:"+voice);
            /**通知 生产者*/
            this.notifyAll();
            this.flag=!this.flag;

        }



    }


}


