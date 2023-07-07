package A13_四大函数式接口_重点_重点;

import java.util.function.Function;

public class A01_Function_函数型接口_传入参数_返回参数 {
    public static void main(String[] args) {

        /**创建Function函数式接口——传入参数_返回参数（传入参数，返回类型）)*/
        Function<String, String> Function1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        /**使用函数式接口*/
        System.out.println(Function1.apply("A"));

        /**---------------------lambda表达式----------------*/
        /**创建Function函数式接口——传入参数_返回参数*/
        Function<String, String> Function2 = (str)->{return "B";};
        System.out.println(Function2.apply("B"));


    }
}
