package A17_volatliede的可见性_非原子性_指令重排;


public class A01_volatile的可见性 {
   private volatile static int i=0;
    public static void main(String[] args) throws InterruptedException {
        new  Thread(()->{
              while (i==0){
                  System.out.println(Thread.currentThread().getName());
              }

          }).start();


        i=1;
        System.out.println(Thread.currentThread().getName());
    }
}
