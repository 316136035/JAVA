import java.util.Random;

public class A02创建带规律的随机数 {
    public static void main(String[] args) {


        /**创建带规律的随机数(种子)*/
        Random random = new Random(100);
        for (int i = 0; i < 100; i++) {
            /**int返回从该随机数生成器的序列中提取的伪随机、均匀分布的值，介于 0（含）和指定值（不含）之间。*/
            System.out.print(random.nextInt(100)+"   ");
        }

    }
}
