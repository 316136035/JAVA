package A03_线程的方法;


/**Join合并线程，待此线程执行完成后，再执行其他线程，其他线程阻*/
public class A04线程的强转执行Join {
    public static void main(String[] args) {
        JoinText joinText = new JoinText();
        Thread thread = new Thread( joinText);
        thread.start();


        for (int i = 1; i <=10000 ; i++) {
            System.out.println("主线程......"+i);
            if (i==100){
                try {
                    /**线程的强转执行*/
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
class JoinText implements  Runnable{
    @Override
    public void run() {
        for (int i =1 ; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+"VIP："+i);
        }


    }
}