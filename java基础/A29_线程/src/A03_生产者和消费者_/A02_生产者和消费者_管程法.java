package A03_生产者和消费者_;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者使用缓冲区来解决
 */
public class A02_生产者和消费者_管程法 {
    public static void main(String[] args) {

        System.out.println(".........");
        /**创建缓冲区对象*/
        SynContainer1 SynContainer1 = new SynContainer1();
        /**创建生产者对象*/
        Productor1 productor = new Productor1(SynContainer1);
        /**创建消费者对象*/
        Consumer1 consumer = new Consumer1(SynContainer1);
        new Thread(productor).start();
        new Thread(consumer).start();

    }
}

/**
 * 生产者
 */
class Productor1 implements Runnable {
    /**
     * 定义缓冲区
     */
    SynContainer1 synContainer1;

    public Productor1( SynContainer1 SynContainer1) {
        this.synContainer1 =  SynContainer1;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synContainer1.push(new Chicken1(i));
            System.out.println("生产了第" + i + "鸡");
            i++;
             if (i%10==0){
                 try {
                     TimeUnit.MILLISECONDS.sleep(1000);
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
class Consumer1 implements Runnable {
    /**
     * 定义缓冲区
     */
    SynContainer1 SynContainer1;
    public  Consumer1(SynContainer1 synContainer1){
        this.SynContainer1=synContainer1;
    }

    @Override
    public void run() {

        while (true) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Chicken1 pop = SynContainer1.pop();
            if (pop!=null){    System.out.println("            消费了第" +pop.getId() + "鸡");}




        }


    }
}

class Chicken1 {
    public Chicken1(int id) {
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
class SynContainer1 {
    /**
     * 定义缓冲区集合
     */

    LinkedList<Chicken1> linkedList = new LinkedList<>();
    /**
     * 添加数据的方法
     */
    public synchronized void push(Chicken1 chicken) {

        /**判断数组是否为0*/
        if (null == linkedList) {
            try {
                /**通知消费者等待*/
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (null != linkedList){
            linkedList.addFirst(chicken);
        }
    }

    /**
     * 删除(消费)数据的方法
     */
    public synchronized Chicken1 pop() {
        Chicken1 chicken = null;
        /**判断数组是否为0*/
        if (linkedList.size()<=0) {
            /**通知生产者生产*/
            this.notify();

        }
        if (linkedList.size()>0)  {
            //System.out.println("数组长度:"+linkedList+" "+linkedList.size());
            chicken = linkedList.removeLast();

        }



        return chicken;
    }


}

