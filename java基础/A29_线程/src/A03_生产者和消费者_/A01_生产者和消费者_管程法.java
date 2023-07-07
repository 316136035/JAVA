package A03_生产者和消费者_;

import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者使用缓冲区来解决
 */
public class A01_生产者和消费者_管程法 {
    public static void main(String[] args) {
        /**创建缓冲区对象*/
        SynContainer synContainer = new SynContainer();
        /**创建生产者对象*/
        Productor productor = new Productor(synContainer);
        /**创建消费者对象*/
        Consumer consumer = new Consumer(synContainer);
        new Thread(productor).start();
        new Thread(consumer).start();

    }
}

/**
 * 生产者
 */
class Productor implements Runnable {
    /**
     * 定义缓冲区
     */
    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {

            synContainer.push(new Chicken(i));
            System.out.println("生产了第" + i + "鸡");
            i++;
            if (i>=100){
                try {
                    TimeUnit.MILLISECONDS.sleep(110);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    /**
     * 定义缓冲区
     */
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Chicken pop = synContainer.pop();

          if (pop!=null){
                System.out.println("消费了第" + pop.getId()+ "鸡");
           }






        }


    }
}

/**对象*/
class Chicken {
    public Chicken(int id) {
        this.id = id;
    }

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "id=" + id +
                '}';
    }
}

/**
 * 缓冲区
 */
class SynContainer {
    /**
     * 定义缓冲区数组
     */
 Chicken[] chickens = new Chicken[10];
    /**
     * 定义缓冲区∴
     */
    int count = 0;

    /**
     * 添加数据的方法
     */
    public synchronized void push(Chicken chicken) {
        /**判断数组是否为0*/
        if (count== chickens.length) {
            try {
                /**通知消费者等待*/
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (count!= chickens.length){
            /**存入数组*/
            chickens[count] = chicken;
            count++;
           // System.out.println(Arrays.toString(chickens));
        }


    }

    /**
     * 删除(消费)数据的方法
     */
    public synchronized Chicken pop() {
        Chicken chicken=null;
        /**判断数组是否为0*/
        if (count <= 0) {
            /**通知生产者生产*/
            this.notify();

        }
        if (count > 0){
            /**如果可以消费*/
            count--;
            chicken = chickens[count];

        //    System.out.println(count);
        }
        return chicken;
    }


}

