public class A02关键字final {
    public static void main(String[] args) {

        Pson pson = new Pson();


    }
}

/**
 * Fina修饰在类中  是不能被继承的。。
 * final class A {}
 **/
class Pson {
    /**Fina修饰局部变量的话，这个变量不能修改，一定要赋值。。*/
    final double age = 3.14;
    String name;

    /**
     * 这个方法可以被继承,但是不能被重写
     */
    public final void sleep() {
        System.out.println("...");

    }


}