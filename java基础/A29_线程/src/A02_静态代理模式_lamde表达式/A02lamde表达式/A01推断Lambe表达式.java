package A02_静态代理模式_lamde表达式.A02lamde表达式;

/**
 *任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接
 *对于函数式接口，我们可以通过lambda表达式来创建该接口的对象。
 *
 * */
public class A01推断Lambe表达式 {
    /**
     * 静态类部类
     */
    static class Linde静态类部类 implements Lande {
        @Override
        public void LandeText() {
            System.out.println("静态实现类");
        }
    }


    public static void main(String[] args) {
        /**外部类*/
        Lande外部类 lande外部类 = new Lande外部类();
        lande外部类.LandeText();
        /**静态类部类*/
        Linde静态类部类 linde静态类部类 = new Linde静态类部类();
        linde静态类部类.LandeText();


        /**局部类部类*/
        class Lamde局部类部类 implements Lande {
            @Override
            public void LandeText() {
                System.out.println("局部类部类");
            }
        }
        /**局部类部类*/
        Lamde局部类部类 lamde局部类部类 = new Lamde局部类部类();
        lamde局部类部类.LandeText();


        /**匿名类部类*/
        Lande lande = new Lande() {
            @Override
            public void LandeText() {
                System.out.println("匿名类部类");
            }
        };
        lande.LandeText();

        /**lamde表达式*/
        Lande landelamde=()-> {
            System.out.println("lamde表达式");

            };
        };

    }




interface Lande {
    void LandeText();
}

/**
 * 外部类
 */
class Lande外部类 implements Lande {
    @Override
    public void LandeText() {
        System.out.println("外部类");


    }
}