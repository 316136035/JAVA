package A04_并发_多个线程使用同一个资源不安全;

public class A02线程并发_银行取线 {
    public static void main(String[] args) {

        Account account = new Account(1000000, "账号:845465123456478421");


        Drawing 线程一 = new Drawing(account, 1000, "线程一");
        线程一.start();


        Drawing 线程二 = new Drawing(account, 2000, "线程二");
        线程二.start();

    }
}
class Account{
    /**余额*/
    int money;
    /**卡号:*/
    String id;
    public  Account(int money, String id) {
        this.money = money;
        this.id = id;
    }
}


class Drawing extends  Thread{
    /**账号*/
    Account  account;
    /**要取多小钱*/
    int draeingMoney;
    /**线程名字*/
    int nowMoney;

    public  Drawing( Account account,int draeingMoney,String  name){
        super(name);
        this.account=account;
        this.draeingMoney=draeingMoney;

    }

    @Override
    public void run() {
        /**把Drawing卡号对象作为锁，那个线程拿到这个对象，下一个线程就要等待*/
        synchronized (account){
            /**判断是否有钱
             */
            if (account.money-draeingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够,取不了");
                return;
            }
            else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                /**卡内余额*/
                account.money= account.money-draeingMoney;

                /**手里的钱*/
                nowMoney= nowMoney+draeingMoney;

                System.out.println(account.id+"余额为:"+account.money);
                System.out.println(this.getName()+" "+Thread.currentThread().getName()+this.nowMoney);

            }



        }




    }
}