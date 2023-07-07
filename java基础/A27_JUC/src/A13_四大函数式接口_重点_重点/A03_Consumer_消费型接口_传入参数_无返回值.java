package A13_四大函数式接口_重点_重点;

import java.util.function.Consumer;

public class A03_Consumer_消费型接口_传入参数_无返回值 {
    public static void main(String[] args) {

        /**创建Consumer_消费型接口_传入参数_无返回值*/
        Consumer consumer1 = new Consumer<String>() {

            @Override
            public void accept(String s) {

                System.out.println(s);
            }
        };
        consumer1.accept("创建Consumer_消费型接口");

        /**---------------------lambda表达式----------------*/
        Consumer consumer2 =(str)->{
            System.out.println(str);
        };
        consumer2.accept("lambda表达式");







    }
}
