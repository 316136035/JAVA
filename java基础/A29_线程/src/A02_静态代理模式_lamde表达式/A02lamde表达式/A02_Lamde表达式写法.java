package A02_静态代理模式_lamde表达式.A02lamde表达式;

/**
 * 任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接
 * 对于函数式接口，我们可以通过lambda表达式来创建该接口的对象。
 */
public class A02_Lamde表达式写法 {
    public static void main(String[] args) {

        /**没有参数的写法*/
        Lande LandeText1 = () -> {
            System.out.println("Lamde表达式写法");
        };
        /**有参数的写法*/
        LandeText2 landeText2 = (str) -> {
            return "我爱你";
        };

        String string = landeText2.LandeT("..");
        System.out.println(string);


        /**多个参数的写法*/
        LandeText3 landeText3 = ( str,integer) -> {
            return "我爱你";
        };
        String string1 = landeText3.LandeT("哈哈", 19);
        System.out.println(string1);

    }

    ;

}

/**
 * 没有参数的接口
 */
interface LandeText1 {
    void LandeT();
}

/**
 * 有参数的接口
 */
interface LandeText2 {
    String LandeT(String str);
}

/**
 * 多个参数的接口
 */
interface LandeText3 {
    String LandeT(String str, Integer integer);
}