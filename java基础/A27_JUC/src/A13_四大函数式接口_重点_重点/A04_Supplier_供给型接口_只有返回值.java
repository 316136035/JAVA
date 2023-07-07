package A13_四大函数式接口_重点_重点;

import java.util.function.Supplier;

public class A04_Supplier_供给型接口_只有返回值 {
    public static void main(String[] args) {
        /**创建供给型接口_只有返回值*/
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "Supplier_供给型接口_只有返回值";
            }
        };

        System.out.println(supplier1.get());

        /**---------------------lambda表达式----------------*/

        Supplier<String> supplier2 = ()->{return "Supplier_供给型接口_只有返回值" ;};
        System.out.println(supplier2.get());


    }
}
