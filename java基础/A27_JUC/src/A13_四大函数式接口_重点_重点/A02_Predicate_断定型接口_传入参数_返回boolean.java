package A13_四大函数式接口_重点_重点;

import java.util.function.Predicate;

public class A02_Predicate_断定型接口_传入参数_返回boolean {
    public static void main(String[] args) {
        /**创建Predicate_断定型接口_传入参数_返回boolean*/
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate1.test(""));


        /**---------------------lambda表达式----------------*/
        /**创建Predicate_断定型接口_传入参数_返回boolean*/
        Predicate<String> predicate2= (str)->{return str.isEmpty();};
        System.out.println(predicate2.test(""));


    }


}
