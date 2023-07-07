import java.util.concurrent.TimeUnit;

public class A09break和continue {
    public static void main(String[] args) throws InterruptedException {
/**需求:运动会上跑5000米，跑到第三圈时喝水,跑到第8圈 抽筋了退赛*/

        for (int i = 1; i <100 ; i++) {

            System.out.println("正在跑第"+i+"圈");

            if (i==3){
                System.out.println("喝水中....");
                TimeUnit.MILLISECONDS.sleep(1000);
                continue;//继续执行当前循环
            }


            if (i==8){
                System.out.println("抽筋了退赛");
                break;}// break跳出当前循环
        }



    }
}
