package A01内部类_匿名内部类;


interface 匿名内部类 {
    public void work();
}


public class A02匿名内部类 {

    int  i=1;
    public static void main(String[] args) {
        /**这是临时的匿名内部类
         *我们new 的不是接口的实例，接口是不能创建对象的，
         * 我们new的是一个实现了 匿名内部类 接口的一个类*/
        new 匿名内部类() {
            public void work() {
                System.out.println("匿名内部类");

            }
        }.work();

    }
}
